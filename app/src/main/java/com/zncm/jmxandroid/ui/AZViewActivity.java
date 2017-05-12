package com.zncm.jmxandroid.ui;

import android.content.Context;
import android.os.Bundle;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

public class AZViewActivity extends BaseAc {

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azview);
        ctx = this;
    }
}
