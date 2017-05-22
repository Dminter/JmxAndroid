package com.zncm.jmxandroid.mykotlin

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

import com.zncm.jmxandroid.R

/**
 * Created by jiaomx on 2017/5/19.
 */

class MyDemo2 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin2)
        val tv001 = findViewById(R.id.tv001) as TextView
    }
}
