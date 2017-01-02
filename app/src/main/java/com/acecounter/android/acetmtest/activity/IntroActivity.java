package com.acecounter.android.acetmtest.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.acecounter.android.acetm.AceTM;
import com.acecounter.android.acetmtest.R;

/**
 * Created by MoonJongRak on 2016. 12. 7..
 */

public class IntroActivity extends AppCompatActivity {

    private Thread delayThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        AceTM.onCreate(this);
        checkAdClick();
        delayThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1500);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(IntroActivity.this, MainActivity.class));
                            finish();
                        }
                    });
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        delayThread.start();
    }

    @Override
    protected void onDestroy() {
        if (delayThread != null) {
            delayThread.interrupt();
        }
        super.onDestroy();

    }

    private void checkAdClick() {
        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            if (uri != null) {
                String tk = uri.getQueryParameter("tk");
                Log.d("****", uri + "");
                if (tk != null) {
                    Toast.makeText(this, "광고배너를 통해 유입 tk:" + tk, Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }
    }
}
