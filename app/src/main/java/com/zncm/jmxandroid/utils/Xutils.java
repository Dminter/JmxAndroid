package com.zncm.jmxandroid.utils;

import android.util.Log;
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



}
