package com.zncm.jmxandroid.hook;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zncm.jmxandroid.R;

public class HookAActivity extends AppCompatActivity {

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hooka);
        ctx = this;
    }
}
