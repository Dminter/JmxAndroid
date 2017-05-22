package com.zncm.jmxandroid.mykotlin

import android.content.Intent
import android.os.Bundle
import com.zncm.jmxandroid.R
import com.zncm.jmxandroid.base.BaseAc
import kotlinx.android.synthetic.main.activity_m.*

/**
 * Created by jiaomx on 2017/5/18.
 */

class MyKotlinDemo : BaseAc() {
    override fun getLayoutResource(): Int {
       return R.layout.activity_m
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnMyKotlinDemo2.setOnClickListener {
            /**
             *  android.content.ActivityNotFoundException: Unable to find explicit activity class {com.zncm.jmxandroid/com.zncm.jmxandroid.mykotlin.MyKotlinDemo2}; have you declared this activity in your AndroidManifest.xml?
             *
             */
            startActivity(Intent(this,MyKotlinDemo2::class.java))
        }

    }

}