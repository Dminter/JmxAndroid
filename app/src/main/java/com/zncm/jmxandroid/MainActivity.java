package com.zncm.jmxandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zncm.imbrary.ImActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                startActivity(new Intent(ctx, ImgActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(ctx, GlobalLocalAct.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(ctx, SmoothImgActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(ctx, ImActivity.class));
                break;
            case R.id.colorpickerview:
                startActivity(new Intent(ctx, ColorpickerviewActivity.class));
                break;


            default:
                break;
        }
    }
}
