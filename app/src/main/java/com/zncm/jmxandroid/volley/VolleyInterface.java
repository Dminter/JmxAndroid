package com.zncm.jmxandroid.volley;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by jiaomx on 2017/5/7.
 */

public abstract class VolleyInterface {
    public Context context;
    public static Response.Listener<String> mListener;
    public static Response.ErrorListener mErrorListener;

    public VolleyInterface(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this.context = context;
        this.mListener = listener;
        this.mErrorListener = errorListener;
    }


    public abstract void onMySuccess(String result);

    public abstract void onMyError(VolleyError result);


    public Response.Listener<String> myListener() {

        mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                onMySuccess(response);
            }
        };
        return mListener;
    }

    public Response.ErrorListener myErrorListener() {

        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onMyError(error);
            }
        };

        return mErrorListener;
    }


}
