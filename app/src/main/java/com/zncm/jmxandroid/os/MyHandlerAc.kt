package com.zncm.jmxandroid.os

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Toast
import com.zncm.jmxandroid.R
import com.zncm.jmxandroid.base.BaseAc
import kotlinx.android.synthetic.main.activity_kotlin3.*
import org.jetbrains.anko.ctx
import java.util.*

/**
 * Created by jiaomx on 2017/5/22.
 */
public class MyHandlerAc : BaseAc() {
    override fun getLayoutResource(): Int {
       return R.layout.activity_kotlin3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tv003.setText("111111")
        var    handler =object :Handler(){
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                var msgStr:String = msg!!.obj as String
                tv003.setText(msgStr)
                Toast.makeText(ctx,msgStr,Toast.LENGTH_SHORT).show()
            }
        }
        tv003.setOnClickListener {
            var msg=Message()
            msg.obj= Random().nextLong().toString()
            handler.handleMessage(msg)
        }
    }
}


