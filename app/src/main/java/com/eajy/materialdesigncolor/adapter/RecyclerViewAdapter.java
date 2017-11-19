package com.eajy.materialdesigncolor.adapter;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eajy.materialdesigncolor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhang on 2016.08.07.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context context;
    private String[] colorNames;
    private String[] colorValues;
    private String[] textColors;

    public RecyclerViewAdapter(Context context, String[] colorNames, String[] colorValues, String[] textColors) {
        this.context = context;
        this.colorNames = colorNames;
        this.colorValues = colorValues;
        this.textColors = textColors;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.setIsRecyclable(false);

        holder.relative_item.setBackgroundColor(Color.parseColor(colorValues[position]));

        holder.tv_recycler_name.setText(colorNames[position]);
        holder.tv_recycler_value.setText(colorValues[position]);

        if (textColors[position].equals("White")) {
            holder.tv_recycler_name.setTextColor(Color.WHITE);
            holder.tv_recycler_value.setTextColor(Color.WHITE);
        } else {
            holder.tv_recycler_name.setTextColor(Color.BLACK);
            holder.tv_recycler_value.setTextColor(Color.BLACK);
        }

        if (position == 10) {
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 12, 0, 0);
            holder.relative_item.setLayoutParams(lp);
        }

        holder.mView.setLongClickable(true);
        holder.mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                cmb.setText(colorValues[position]);
                Snackbar.make(holder.mView, context.getString(R.string.copy_before) + colorValues[position] + context.getString(R.string.copy_after),
                        Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return textColors.length;
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private View mView;
        private RelativeLayout relative_item;
        private TextView tv_recycler_name, tv_recycler_value;

        private RecyclerViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            relative_item = itemView.findViewById(R.id.relative_item);
            tv_recycler_name = itemView.findViewById(R.id.tv_recycler_name);
            tv_recycler_value = itemView.findViewById(R.id.tv_recycler_value);
        }
    }

}
