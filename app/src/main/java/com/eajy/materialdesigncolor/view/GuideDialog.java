package com.eajy.materialdesigncolor.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eajy.materialdesigncolor.R;

/**
 * Created by zhang on 2017.04.19.
 */

public class GuideDialog extends AppCompatDialog {

    private RelativeLayout relative_guide, relative_guide_background;
    private TextView tv_guide;
    private ImageView img_guide_left, img_guide_right;

    public GuideDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_guide);

        initView();
    }

    private void initView() {
        relative_guide = (RelativeLayout) findViewById(R.id.relative_guide);
        relative_guide_background = (RelativeLayout) findViewById(R.id.relative_guide_background);
        tv_guide = (TextView) findViewById(R.id.tv_guide);
        img_guide_left = (ImageView) findViewById(R.id.img_guide_left);
        img_guide_right = (ImageView) findViewById(R.id.img_guide_right);

        relative_guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation dismissAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_guide_dismiss);
                dismissAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        dismiss();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                relative_guide_background.startAnimation(dismissAnimation);

                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000);
                tv_guide.startAnimation(alphaAnimation);
                img_guide_left.startAnimation(alphaAnimation);
                img_guide_right.startAnimation(alphaAnimation);
            }
        });

    }


}
