package com.zncm.jmxandroid.baseview;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.view.pd.PDColorSelView;
import com.zncm.jmxandroid.view.pd.PDCropImageView;
import com.zncm.jmxandroid.view.pd.PDPaintView;
import com.zncm.jmxandroid.view.TextFloatView;

/**
 * Created by jiaomx on 2017/5/25.
 */

public class MyPaintAc extends BaseAc {
    TextFloatView mTextFloatView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PDPaintView paintView = (PDPaintView) findViewById(R.id.mPaintView);
        final PDCropImageView mPDCropImageView = (PDCropImageView) findViewById(R.id.mPDCropImageView);


        Drawable drawable = getDrawable(R.drawable.img1);
        if (drawable!=null){
            RectF imgRectF  = new RectF();
            imgRectF.set(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
            mPDCropImageView.setImgRectF(imgRectF);
        }



        Button undo = (Button) findViewById(R.id.undo);
        PDColorSelView mColorSelView =  (PDColorSelView) findViewById(R.id.mColorSelView);


        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.undo();
            }
        });

        Button text = (Button) findViewById(R.id.text);
        Button crop = (Button) findViewById(R.id.crop);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        final  EditText mEditText= (EditText) findViewById(R.id.mEditText);
         Button editTextSure = (Button) findViewById(R.id.editTextSure);
          mTextFloatView = (TextFloatView) findViewById(R.id.mTextFloatView);
        editTextSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = mEditText.getText().toString().trim();
                if (TextUtils.isEmpty(text)){
                    return;
                }
                mTextFloatView.setText(text);
            }
        });
        mColorSelView.setmOnColorSelListener(new PDColorSelView.OnColorSelListener() {
            @Override
            public void onColorSelListener(int color) {
                paintView.setColor(color);
                mTextFloatView.setColor(color);
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_mypaint;
    }
}
