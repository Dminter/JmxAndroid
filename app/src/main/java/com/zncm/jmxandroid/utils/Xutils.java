package com.zncm.jmxandroid.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.zncm.jmxandroid.base.MyApp;

/**
 * Created by dminter on 2017/3/8.
 */

public class Xutils {

    public static void debug(Object obj) {
        Log.d("jmx_a", obj.toString());
    }

    public static boolean isEmptyOrNull(String string) {

        return string == null || string.trim().length() == 0 || string.equals("null");


    }

    public static boolean isNotEmptyOrNull(String string) {
        return !isEmptyOrNull(string);

    }
    public static void tShort(String msg) {
        if (isEmptyOrNull(msg)) {
            return;
        }
        Toast.makeText(MyApp.getInstance().ctx, msg, Toast.LENGTH_SHORT).show();
    }

    public static void tLong(String msg) {
        if (isEmptyOrNull(msg)) {
            return;
        }
        Toast.makeText(MyApp.getInstance().ctx, msg, Toast.LENGTH_LONG).show();
    }





    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = MyApp.getInstance().ctx.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = MyApp.getInstance().ctx.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static final WindowManager wm = (WindowManager) MyApp.getInstance().ctx.getSystemService(Context.WINDOW_SERVICE);

    public static DisplayMetrics getDeviceMetrics() {
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    public static int getDeviceHeight() {
        return getDeviceMetrics().heightPixels;
    }

    public static int getDeviceWidth() {
        return getDeviceMetrics().widthPixels;
    }















}
