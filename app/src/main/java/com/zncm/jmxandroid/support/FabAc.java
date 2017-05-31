package com.zncm.jmxandroid.support;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.utils.Xutils;

/**
 * Created by jiaomx on 2017/5/25.
 */

/**
 * 原生的FloatingActionButton
 *  android.support.design.widget.FloatingActionButton;
 * android:backgroundTint="" 设置按钮颜色或者代码里面用setBackgroundTintList
 */
public class FabAc extends BaseAc{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FloatingActionButton    fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabAdd.setImageResource(R.drawable.ic_info);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xutils.debug("onClick");
            }
        });
        fabAdd.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Xutils.debug("onLongClick");
                return true;
            }
        });

        /**
         *设置按钮颜色
         */
        fabAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.material_blue_400)));


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_supportdesignfab;
    }
}
