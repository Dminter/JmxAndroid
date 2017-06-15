package com.zncm.jmxandroid.github;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageButton;

import java.io.IOException;

public class GifActivity extends BaseAc {
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        try {
            GifDrawable gifFromAssets = new GifDrawable( getAssets(), "mygif.gif" );
            if (gifFromAssets!=null){
                gifFromAssets.start();
            }
            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            imageView.setImageDrawable(gifFromAssets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_gif;
    }
}
