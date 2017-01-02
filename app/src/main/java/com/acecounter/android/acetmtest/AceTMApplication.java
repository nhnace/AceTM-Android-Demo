package com.acecounter.android.acetmtest;

import android.app.Application;

import com.acecounter.android.acetm.AceTM;

/**
 * Created by MoonJongRak on 2016. 11. 17..
 */

public class AceTMApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AceTM.init(this);
    }
}
