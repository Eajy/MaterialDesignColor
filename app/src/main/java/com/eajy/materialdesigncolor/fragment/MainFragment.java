package com.eajy.materialdesigncolor.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eajy.materialdesigncolor.R;
import com.eajy.materialdesigncolor.adapter.RecyclerViewAdapter;

/**
 * Created by zhang on 2016.08.07.
 */
public class MainFragment extends Fragment {

    private RelativeLayout relative_title;
    private TextView tv_header_title, tv_header_name, tv_header_value;
    private RecyclerView recycler_main;

    private String title;
    private String[] colorNames;
    private String[] colorValues;
    private String[] textColors;

    public MainFragment() {

    }

    // Create a new instance of Fragment that will be initialized with the given arguments.
    public MainFragment newInstance(String title, String[] colorNames, String[] colorValues, String[] textColors) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putStringArray("colorNames", colorNames);
        bundle.putStringArray("colorValues", colorValues);
        bundle.putStringArray("textColors", textColors);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_main, container, false);
        relative_title = linearLayout.findViewById(R.id.relative_title);
        tv_header_title = linearLayout.findViewById(R.id.tv_header_title);
        tv_header_name = linearLayout.findViewById(R.id.tv_header_name);
        tv_header_value = linearLayout.findViewById(R.id.tv_header_value);
        recycler_main = linearLayout.findViewById(R.id.recycler_main);
        return linearLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //获取传递到Fragment中的参数
        Bundle args = getArguments();
        if (args != null) {
            title = args.getString("title");
            colorNames = args.getStringArray("colorNames");
            colorValues = args.getStringArray("colorValues");
            textColors = args.getStringArray("textColors");

            initDada();
        }
    }

    private void initDada() {
        tv_header_title.setText(title);

        if (colorNames != null && colorNames.length > 6) {
            tv_header_name.setText(colorNames[5]);
            tv_header_value.setText(colorValues[5]);
            relative_title.setBackgroundColor(Color.parseColor(colorValues[5]));

            if (textColors[5].equals("White")) {
                tv_header_title.setTextColor(Color.WHITE);
                tv_header_name.setTextColor(Color.WHITE);
                tv_header_value.setTextColor(Color.WHITE);
            } else {
                tv_header_title.setTextColor(Color.BLACK);
                tv_header_name.setTextColor(Color.BLACK);
                tv_header_value.setTextColor(Color.BLACK);
            }
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), colorNames, colorValues, textColors);
        recycler_main.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler_main.setAdapter(adapter);
    }

}
