package com.zncm.jmxandroid.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.zncm.jmxandroid.base.MyApp;

import java.util.Map;

/**
 * Created by jiaomx on 2017/5/7.
 */

public class VolleyRequest {
    public static StringRequest stringRequest;
    public static Context context;

    public static void RequestGet(Context ctx, String url, String tag, VolleyInterface volleyInterface) {
        MyApp.getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, volleyInterface.myListener(), volleyInterface.myErrorListener());
        stringRequest.setTag(tag);
        MyApp.getRequestQueue().add(stringRequest);
    }

    public static void RequestPost(Context ctx, String url, String tag, final Map<String, String> params, VolleyInterface volleyInterface) {
        MyApp.getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.POST, url, volleyInterface.myListener(), volleyInterface.myErrorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApp.getRequestQueue().add(stringRequest);
    }


}
