package com.eajy.materialdesigncolor.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eajy.materialdesigncolor.Constant;
import com.eajy.materialdesigncolor.R;
import com.eajy.materialdesigncolor.adapter.FragmentAdapter;
import com.eajy.materialdesigncolor.fragment.MainFragment;
import com.eajy.materialdesigncolor.view.GuideDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ImageView img_main_toggle;
    private ViewPager view_pager_main;
    private RelativeLayout relative_main;

    private static boolean isShowPageStart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.argb(33, 0, 0, 0));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        img_main_toggle = (ImageView) findViewById(R.id.img_main_toggle);
        img_main_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });

        initViewPager();

        relative_main = (RelativeLayout) findViewById(R.id.relative_main);
        if (isShowPageStart) {
            relative_main.setVisibility(View.VISIBLE);
            showStartPage();
            isShowPageStart = false;
        }

    }

    private void initViewPager() {
        view_pager_main = (ViewPager) findViewById(R.id.view_pager_main);

        String[] colorList = getResources().getStringArray(R.array.colorList);
        final String[] colorListColors = getResources().getStringArray(R.array.colorListColors);

        String[] colorNames = getResources().getStringArray(R.array.colorNames);

        String[] redTextValues = (getResources().getStringArray(R.array.redTextValues));
        String[] redTextColors = (getResources().getStringArray(R.array.redTextColors));
        String[] pinkTextValues = (getResources().getStringArray(R.array.pinkTextValues));
        String[] pinkTextColors = (getResources().getStringArray(R.array.pinkTextColors));
        String[] purpleTextValues = (getResources().getStringArray(R.array.purpleTextValues));
        String[] purpleTextColors = (getResources().getStringArray(R.array.purpleTextColors));
        String[] deepPurpleTextValues = (getResources().getStringArray(R.array.deepPurpleTextValues));
        String[] deepPurpleTextColors = (getResources().getStringArray(R.array.deepPurpleTextColors));
        String[] indigoTextValues = (getResources().getStringArray(R.array.indigoTextValues));
        String[] indigoTextColors = (getResources().getStringArray(R.array.indigoTextColors));
        String[] blueTextValues = (getResources().getStringArray(R.array.blueTextValues));
        String[] blueTextColors = (getResources().getStringArray(R.array.blueTextColors));
        String[] lightBlueTextValues = (getResources().getStringArray(R.array.lightBlueTextValues));
        String[] lightBlueTextColors = (getResources().getStringArray(R.array.lightBlueTextColors));
        String[] cyanTextValues = (getResources().getStringArray(R.array.cyanTextValues));
        String[] cyanTextColors = (getResources().getStringArray(R.array.cyanTextColors));
        String[] tealTextValues = (getResources().getStringArray(R.array.tealTextValues));
        String[] tealTextColors = (getResources().getStringArray(R.array.tealTextColors));
        String[] greenTextValues = (getResources().getStringArray(R.array.greenTextValues));
        String[] greenTextColors = (getResources().getStringArray(R.array.greenTextColors));
        String[] lightGreenTextValues = (getResources().getStringArray(R.array.lightGreenTextValues));
        String[] lightGreenTextColors = (getResources().getStringArray(R.array.lightGreenTextColors));
        String[] limeTextValues = (getResources().getStringArray(R.array.limeTextValues));
        String[] limeTextColors = (getResources().getStringArray(R.array.limeTextColors));
        String[] yellowTextValues = (getResources().getStringArray(R.array.yellowTextValues));
        String[] yellowTextColors = (getResources().getStringArray(R.array.yellowTextColors));
        String[] amberTextValues = (getResources().getStringArray(R.array.amberTextValues));
        String[] amberTextColors = (getResources().getStringArray(R.array.amberTextColors));
        String[] orangeTextValues = (getResources().getStringArray(R.array.orangeTextValues));
        String[] orangeTextColors = (getResources().getStringArray(R.array.orangeTextColors));
        String[] deepOrangeTextValues = (getResources().getStringArray(R.array.deepOrangeTextValues));
        String[] deepOrangeTextColors = (getResources().getStringArray(R.array.deepOrangeTextColors));
        String[] brownTextValues = (getResources().getStringArray(R.array.brownTextValues));
        String[] brownTextColors = (getResources().getStringArray(R.array.brownTextColors));
        String[] greyTextValues = (getResources().getStringArray(R.array.greyTextValues));
        String[] greyTextColors = (getResources().getStringArray(R.array.greyTextColors));
        String[] blueGreyTextValues = (getResources().getStringArray(R.array.blueGreyTextValues));
        String[] blueGreyTextColors = (getResources().getStringArray(R.array.blueGreyTextColors));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment().newInstance(colorList[0], colorNames, redTextValues, redTextColors));
        fragments.add(new MainFragment().newInstance(colorList[1], colorNames, pinkTextValues, pinkTextColors));
        fragments.add(new MainFragment().newInstance(colorList[2], colorNames, purpleTextValues, purpleTextColors));
        fragments.add(new MainFragment().newInstance(colorList[3], colorNames, deepPurpleTextValues, deepPurpleTextColors));
        fragments.add(new MainFragment().newInstance(colorList[4], colorNames, indigoTextValues, indigoTextColors));
        fragments.add(new MainFragment().newInstance(colorList[5], colorNames, blueTextValues, blueTextColors));
        fragments.add(new MainFragment().newInstance(colorList[6], colorNames, lightBlueTextValues, lightBlueTextColors));
        fragments.add(new MainFragment().newInstance(colorList[7], colorNames, cyanTextValues, cyanTextColors));
        fragments.add(new MainFragment().newInstance(colorList[8], colorNames, tealTextValues, tealTextColors));
        fragments.add(new MainFragment().newInstance(colorList[9], colorNames, greenTextValues, greenTextColors));
        fragments.add(new MainFragment().newInstance(colorList[10], colorNames, lightGreenTextValues, lightGreenTextColors));
        fragments.add(new MainFragment().newInstance(colorList[11], colorNames, limeTextValues, limeTextColors));
        fragments.add(new MainFragment().newInstance(colorList[12], colorNames, yellowTextValues, yellowTextColors));
        fragments.add(new MainFragment().newInstance(colorList[13], colorNames, amberTextValues, amberTextColors));
        fragments.add(new MainFragment().newInstance(colorList[14], colorNames, orangeTextValues, orangeTextColors));
        fragments.add(new MainFragment().newInstance(colorList[15], colorNames, deepOrangeTextValues, deepOrangeTextColors));
        fragments.add(new MainFragment().newInstance(colorList[16], colorNames, brownTextValues, brownTextColors));
        fragments.add(new MainFragment().newInstance(colorList[17], colorNames, greyTextValues, greyTextColors));
        fragments.add(new MainFragment().newInstance(colorList[18], colorNames, blueGreyTextValues, blueGreyTextColors));

        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        view_pager_main.setAdapter(mFragmentAdapter);

        view_pager_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (colorListColors[position].equals("White")) {
                    img_main_toggle.setImageTintList(ColorStateList.valueOf(Color.WHITE));
                } else {
                    img_main_toggle.setImageTintList(ColorStateList.valueOf(Color.BLACK));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = new Intent();

        switch (item.getItemId()) {
            case R.id.nav_explain:
                intent.setClass(MainActivity.this, ExplainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_website:
                intent.setClass(MainActivity.this, WebActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_about:
                intent.setClass(this, AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_donate:
                intent.setClass(this, DonateActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_md:
                if (checkAppInstalled(Constant.MATERIAL_DESIGN_DEMO_PACKAGE)) {
                    intent = getPackageManager().getLaunchIntentForPackage(Constant.MATERIAL_DESIGN_DEMO_PACKAGE);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    intent.setData(Uri.parse(Constant.MATERIAL_DESIGN_DEMO_URL));
                    intent.setAction(Intent.ACTION_VIEW);
                    startActivity(intent);
                }
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showStartPage() {
        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                        alphaAnimation.setDuration(300);
                        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                relative_main.setVisibility(View.GONE);
                                showGuide();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        relative_main.startAnimation(alphaAnimation);
                    }
                });
            }
        }.start();
    }

    public void showGuide() {
        SharedPreferences sharedPreferences = getSharedPreferences("app", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isFirst", true)) {
            GuideDialog guideDialog = new GuideDialog(MainActivity.this, R.style.DialogFullscreen);
            guideDialog.show();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirst", false);
            editor.apply();
        }
    }

    private boolean checkAppInstalled(String packageName) {
        try {
            getPackageManager().getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
