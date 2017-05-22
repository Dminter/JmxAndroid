package com.zncm.jmxandroid.mykotlin

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.zncm.jmxandroid.R
import kotlinx.android.synthetic.main.activity_kotlin2.*

/**
 * Created by jiaomx on 2017/5/19.
 */
class MyKotlinDemo2: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin2)
        tv001.setText("this is a text!")
        et001.setText("请输入")
    }
}