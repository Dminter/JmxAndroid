package com.zncm.jmxandroid.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zncm.jmxandroid.R;

/**
 * Created by jiaomx on 2017/6/15.
 */

public class ColorSelView extends LinearLayout {
    int colors[] = new int[]{0xFF000000, 0xFF9900FF, 0xFF0000FF, 0xFF00FF00, 0xFF00FFFF, 0xFFFF0000, 0xFFFF00FF, 0xFFFF6600, 0xFFFFFF00, 0xFFFFFFFF, 0xFF000000};
    int selColor = colors[0];

    int strokeWidth = 5; // 3dp 边框宽度
    int roundRadius = 15; // 8dp 圆角半径
    LinearLayout linearLayout;

    Context ctx;

    OnColorSelListener mOnColorSelListener;


    public ColorSelView(Context context) {
        super(context);
        ctx = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        linearLayout = new LinearLayout(ctx);
        View view = inflater.inflate(R.layout.pd_colorselview, linearLayout);
        LayoutParams layoutParams = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setHorizontalGravity(HORIZONTAL);
        addView(linearLayout);
        refreshView();
    }

    private void refreshView() {
        linearLayout.removeAllViews();
        for (int color : colors
                ) {
            ImageView imageView = drawRound(color);
            if (imageView != null) {
                linearLayout.addView(imageView);
            }
        }

    }

    @SuppressLint("WrongConstant")
    private ImageView drawRound(final int color) {
        ImageView imageView = new ImageView(ctx);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(60, 60));
        imageView.setPadding(10, 10, 10, 10);
        int strokeColor = color;//边框颜色
        if (color != selColor) {
            strokeColor = Color.WHITE;//边框颜色
        }
        int fillColor = color;//内部填充颜色
        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);
        gd.setCornerRadius(roundRadius);
        gd.setStroke(strokeWidth, strokeColor);
        imageView.setImageDrawable(gd);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selColor = color;
                if (mOnColorSelListener!=null){

                mOnColorSelListener.onColorSelListener(selColor);
                }
                refreshView();
            }
        });
        return imageView;
    }

    public ColorSelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
        init();
    }


    public interface OnColorSelListener{
        void onColorSelListener(int color);
    }


    public void setmOnColorSelListener(OnColorSelListener mOnColorSelListener) {
        this.mOnColorSelListener = mOnColorSelListener;
    }
}
