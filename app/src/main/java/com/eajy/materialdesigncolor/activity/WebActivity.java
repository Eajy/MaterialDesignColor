package com.eajy.materialdesigncolor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.eajy.materialdesigncolor.Constant;
import com.eajy.materialdesigncolor.R;

public class WebActivity extends AppCompatActivity {

    private WebView web_view;
    private ProgressBar progress_bar_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_web_view);
        toolbar.setNavigationIcon(R.mipmap.ic_close_white_24dp);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        web_view = (WebView) findViewById(R.id.web_view);
        progress_bar_web = (ProgressBar) findViewById(R.id.progress_bar_web);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setWebView(web_view, Constant.GOOGLE_COLOR_WEBSITE);
    }

    private void setWebView(final WebView mWebView, String url) {
        mWebView.getSettings().setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient() {

        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progress_bar_web.setVisibility(View.VISIBLE);
                progress_bar_web.setProgress(newProgress);
                if (newProgress == 100) {
                    progress_bar_web.setVisibility(View.GONE);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }
            }
        });

        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (mWebView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                    mWebView.goBack();
                    return true;
                }
                return false;
            }
        });

        mWebView.loadUrl(url);
    }
}




