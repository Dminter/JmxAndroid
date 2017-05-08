package com.zncm.jmxandroid.base;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by jiaomx on 2017/5/3.
 */

public class MyApp extends Application {

    public static RequestQueue requestQueue;
    public static MyApp instance;
    public Context ctx;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        ctx = getApplicationContext();
//        HookStartActivityUtils hookStartActivityUtils = new HookStartActivityUtils(this, ProxyActivity.class);
//        try {
//            hookStartActivityUtils.hookStartActivity();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        requestQueue = Volley.newRequestQueue(getApplicationContext());

    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
