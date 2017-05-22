package com.zncm.jmxandroid.os.java;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;

import java.util.Random;

/**
 * Created by jiaomx on 2017/5/22.
 */

public class MyHandlerAcJ extends BaseAc {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextView textView = (TextView)findViewById(R.id.tv003);
        textView.setText("111");

        final Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Toast.makeText(MyHandlerAcJ.this,msg.obj.toString(),Toast.LENGTH_SHORT).show();
                textView.setText(msg.obj.toString());
                return false;
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msgStr = new Random().nextLong()+"";
                Message message = new Message();
                message.obj = msgStr;
                handler.sendMessage(message);
            }
        });




    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_kotlin3;
    }
}
