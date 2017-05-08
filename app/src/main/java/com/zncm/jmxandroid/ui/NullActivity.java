package com.zncm.jmxandroid.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

public class NullActivity extends BaseAc {
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_null);
        ctx = this;
    }
}
