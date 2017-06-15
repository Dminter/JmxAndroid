package com.zncm.jmxandroid.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.view.ColorSelView;
import com.zncm.jmxandroid.view.PaintView;
import com.zncm.jmxandroid.view.TextFloatView;

/**
 * Created by jiaomx on 2017/5/25.
 */

public class PicEditAc extends BaseAc {
    public String filePath;
    public String saveFilePath;
    Context ctx;
    Bitmap baseBitmap;


    TextFloatView mTextFloatView;

    ColorSelView mColorSelView;
    PaintView paintView;
    Button edit;
    Button undo;
    Button text;
    Button crop;

    ImageView baseImageView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;


        baseBitmap = BitmapFactory.decodeResource(ctx.getResources(),
                R.drawable.img1);


        baseImageView = (ImageView) findViewById(R.id.baseImageView);
        baseImageView.setImageBitmap(baseBitmap);

        paintView = (PaintView) findViewById(R.id.mPaintView);
        edit = (Button) findViewById(R.id.edit);
        undo = (Button) findViewById(R.id.undo);
        mColorSelView = (ColorSelView) findViewById(R.id.mColorSelView);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                paintView.setEnabled(true);
            }
        }); undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.undo();
            }
        });

        text = (Button) findViewById(R.id.text);
        crop = (Button) findViewById(R.id.crop);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


//         EditText mEditText= (EditText) findViewById(R.id.mEditText);
//        Button editTextSure = (Button) findViewById(R.id.editTextSure);
        mTextFloatView = (TextFloatView) findViewById(R.id.mTextFloatView);

        mTextFloatView.setText("PMS258");
        //        editTextSure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = mEditText.getText().toString().trim();
//                if (TextUtils.isEmpty(text)){
//                    return;
//                }
//                mTextFloatView.setText(text);
//            }
//        });
        mColorSelView.setmOnColorSelListener(new ColorSelView.OnColorSelListener() {
            @Override
            public void onColorSelListener(int color) {
                paintView.setColor(color);
                mTextFloatView.setColor(color);
            }
        });


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_picedit;
    }
}
