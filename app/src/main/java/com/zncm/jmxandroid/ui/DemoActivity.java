package com.zncm.jmxandroid.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.view.SmoothImageView;

public class DemoActivity extends AppCompatActivity {

    Context ctx;
    SmoothImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgsmooth);
        ctx = this;
        imageView = (SmoothImageView) findViewById(R.id.imageView);

    }
}
