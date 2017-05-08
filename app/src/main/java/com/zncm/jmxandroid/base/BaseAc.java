package com.zncm.jmxandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.zncm.jmxandroid.R;

/**
 * Created by jiaomx on 2017/5/3.
 */

public class BaseAc extends AppCompatActivity {

    Toolbar toolBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        if (toolBar != null) {
        }

    }
}
