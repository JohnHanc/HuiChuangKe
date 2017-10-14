package com.huida.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by liling on 2017/10/1.
 */

public class MyApplication extends Application {
    private static Context mContext;


    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){

        return mContext;
    }

}
