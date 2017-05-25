package com.zncm.jmxandroid.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zncm.jmxandroid.R;

/**
 * Created by jiaomx on 2017/5/23.
 */

public class MyFt extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_tablayoutac_ft,null);
        return view;


    }
}
