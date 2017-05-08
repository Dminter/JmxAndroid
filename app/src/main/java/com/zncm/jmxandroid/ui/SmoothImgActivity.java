package com.zncm.jmxandroid.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.utils.Xutils;
import com.zncm.jmxandroid.view.SmoothImageView;

public class SmoothImgActivity extends AppCompatActivity {

    Context ctx;
    SmoothImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgsmooth);
        ctx = this;
        imageView = (SmoothImageView) findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.mipmap.img1));
        imageView.setOnTransformListener(new SmoothImageView.TransformListener() {
            @Override
            public void onTransformComplete(int mode) {
                Xutils.debug("mode::" + mode);
            }
        });
        imageView.transformIn();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.transformOut();
            }
        });
    }
}
