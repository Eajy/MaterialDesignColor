package com.eajy.materialdesigncolor.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.eajy.materialdesigncolor.R;
import com.eajy.materialdesigncolor.billing.IabBroadcastReceiver;
import com.eajy.materialdesigncolor.billing.IabHelper;
import com.eajy.materialdesigncolor.billing.IabResult;
import com.eajy.materialdesigncolor.billing.Inventory;
import com.eajy.materialdesigncolor.billing.Purchase;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class DonateActivity extends AppCompatActivity implements IabBroadcastReceiver.IabBroadcastListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        initView();

    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_donate);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public void receivedBroadcast() {

    }
}
