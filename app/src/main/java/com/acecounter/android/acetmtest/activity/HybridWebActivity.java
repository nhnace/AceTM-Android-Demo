package com.acecounter.android.acetmtest.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.acecounter.android.acetm.AceTM;
import com.acecounter.android.acetmtest.R;

/**
 * Created by MoonJongRak on 2016. 11. 24..
 */

public class HybridWebActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybrid_web);
        AceTM.onCreate(this);

        webView = (WebView) findViewById(R.id.webView);
        // 웹뷰에서 자바스크립트실행가능
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                AceTM.onPageFinished(view);
                super.onPageFinished(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                AceTM.onPageStart(view);
                super.onPageStarted(view, url, favicon);
            }
        });

        webView.setWebChromeClient(new WebChromeClient());

        webView.loadUrl("http://www.amazingsoft.com/webview/index.html");
    }


}
