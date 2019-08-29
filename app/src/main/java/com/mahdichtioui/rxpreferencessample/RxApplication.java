package com.mahdichtioui.rxpreferencessample;

import android.app.Application;

public class RxApplication extends Application {
    private static RxApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static RxApplication getInstance(){
        return instance;
    }

}
