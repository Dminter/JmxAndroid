package com.zncm.jmxandroid.mykotlin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.zncm.jmxandroid.R;

/**
 * Created by jiaomx on 2017/5/19.
 */

public class MyDemo3 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotlin2);
        TextView tv001=(TextView)findViewById(R.id.tv001);
    }
}
