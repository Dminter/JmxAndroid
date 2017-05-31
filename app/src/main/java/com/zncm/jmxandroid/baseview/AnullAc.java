package com.zncm.jmxandroid.baseview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

/**
 * Created by jiaomx on 2017/5/25.
 */

public class AnullAc  extends BaseAc{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.aa_null;
    }
}
