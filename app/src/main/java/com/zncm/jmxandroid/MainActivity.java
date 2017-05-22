package com.zncm.jmxandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zncm.imbrary.ImActivity;
import com.zncm.jmxandroid.activityshortcut.ActivityShortcut;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.droidplugin.MyActivity;
import com.zncm.jmxandroid.mykotlin.MyKotlinDemo;
import com.zncm.jmxandroid.mykotlin.MyKotlinListView;
import com.zncm.jmxandroid.os.MyHandlerAc;
import com.zncm.jmxandroid.os.java.MyHandlerAcJ;
import com.zncm.jmxandroid.ui.AZViewActivity;
import com.zncm.jmxandroid.ui.BaseViewActivity;
import com.zncm.jmxandroid.ui.ColorpickerviewActivity;
import com.zncm.jmxandroid.ui.GlobalLocalAct;
import com.zncm.jmxandroid.ui.ImgActivity;
import com.zncm.jmxandroid.ui.SmoothImgActivity;
import com.zncm.jmxandroid.ui.ToastyActivity;
import com.zncm.jmxandroid.volley.VolleyDemo;

public class MainActivity extends BaseAc implements View.OnClickListener {

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = this;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.MyKotlinListView:
                startActivity(new Intent(ctx, MyKotlinListView.class));
                break;
                case R.id.MyHandlerAcJ:
                startActivity(new Intent(ctx, MyHandlerAcJ.class));
                break;
                case R.id.MyHandlerAc:
                startActivity(new Intent(ctx, MyHandlerAc.class));
                break;
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
            case R.id.hookaactivity:
                // Caused by: android.content.ActivityNotFoundException: Unable to find explicit activity class {com.zncm.jmxandroid/com.zncm.jmxandroid.hook.HookAActivity}; have you declared this activity in your AndroidManifest.xml?
//                startActivity(new Intent(ctx, HookAActivity.class));
                break;

            case R.id.volleydemo:
                startActivity(new Intent(ctx, VolleyDemo.class));
                break;
            case R.id.BaseViewActivity:
                startActivity(new Intent(ctx, BaseViewActivity.class));
                break;
            case R.id.ToastyActivity:
                startActivity(new Intent(ctx, ToastyActivity.class));
                break;
            case R.id.ActivityShortcut:
                startActivity(new Intent(ctx, ActivityShortcut.class));
                break;
            case R.id.MyActivity:
                startActivity(new Intent(ctx, MyActivity.class));
                break;
            case R.id.AZViewActivity:
                startActivity(new Intent(ctx, AZViewActivity.class));
                break;
                case R.id.MyKotlinDemo:
                startActivity(new Intent(ctx, MyKotlinDemo.class));
                break;
            default:
                break;
        }
    }
}
