package com.zncm.jmxandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

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
