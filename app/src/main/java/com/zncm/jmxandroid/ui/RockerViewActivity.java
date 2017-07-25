package com.zncm.jmxandroid.ui;

import android.content.Context;
import android.os.Bundle;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

public class RockerViewActivity extends BaseAc {
    Context ctx;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_rockerview;
    }
}
