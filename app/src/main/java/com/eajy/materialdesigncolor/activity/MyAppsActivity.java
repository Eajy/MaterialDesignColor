package com.eajy.materialdesigncolor.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eajy.materialdesigncolor.Constant;
import com.eajy.materialdesigncolor.R;
import com.eajy.materialdesigncolor.adapter.MyAppsAdapter;
import com.eajy.materialdesigncolor.model.MyAppsModel;

import java.util.ArrayList;
import java.util.List;

public class MyAppsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apps);

        Toolbar toolbar = findViewById(R.id.toolbar_my_apps);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        RecyclerView recycler_my_apps = findViewById(R.id.recycler_my_apps);
        MyAppsAdapter adapter = new MyAppsAdapter(this, initData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_my_apps.setLayoutManager(linearLayoutManager);
        recycler_my_apps.setAdapter(adapter);
    }

    private List<MyAppsModel> initData() {
        List<MyAppsModel> lists = new ArrayList();

        MyAppsModel model1 = new MyAppsModel();
        model1.setName(Constant.MATERIAL_DESIGN_DEMO);
        model1.setDescription(Constant.MATERIAL_DESIGN_DEMO_DESCRIPTION);
        model1.setPackageName(Constant.MATERIAL_DESIGN_DEMO_PACKAGE);
        model1.setGooglePlayUrl(Constant.MATERIAL_DESIGN_DEMO_URL);
        model1.setImageUrl("material_design_demo");
        lists.add(model1);

        MyAppsModel model2 = new MyAppsModel();
        model2.setName(Constant.FLUTTER_DEMO);
        model2.setDescription(Constant.FLUTTER_DEMO_DESCRIPTION);
        model2.setPackageName(Constant.FLUTTER_DEMO_PACKAGE);
        model2.setGooglePlayUrl(Constant.FLUTTER_DEMO_URL);
        model2.setImageUrl("flutter_demo");
        lists.add(model2);

        MyAppsModel model3 = new MyAppsModel();
        model3.setName(Constant.X_LAUNCHER);
        model3.setDescription(Constant.X_LAUNCHER_DESCRIPTION);
        model3.setPackageName(Constant.X_LAUNCHER_PACKAGE);
        model3.setGooglePlayUrl(Constant.X_LAUNCHER_URL);
        model3.setImageUrl("x_launcher");
        lists.add(model3);

        MyAppsModel model4 = new MyAppsModel();
        model4.setName(Constant.ALL_MESSENGER);
        model4.setDescription(Constant.ALL_MESSENGER_DESCRIPTION);
        model4.setPackageName(Constant.ALL_MESSENGER_PACKAGE);
        model4.setGooglePlayUrl(Constant.ALL_MESSENGER_URL);
        model4.setImageUrl("all_messenger");
        lists.add(model4);

        return lists;
    }
}
