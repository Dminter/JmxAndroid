package com.zncm.jmxandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zncm.imbrary.ImActivity;
import com.zncm.jmxandroid.activityshortcut.ActivityShortcut;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.baseview.ColorSelViewAc;
import com.zncm.jmxandroid.baseview.MyPaintAc;
import com.zncm.jmxandroid.baseview.PicEditAc;
import com.zncm.jmxandroid.baseview.ZoomControlsAc;
import com.zncm.jmxandroid.github.FingerprintIdentifyAc;
import com.zncm.jmxandroid.github.GifActivity;
import com.zncm.jmxandroid.github.Okhttp1Activity;
import com.zncm.jmxandroid.github.PicEditActivity;
import com.zncm.jmxandroid.github.PopListActivity;
import com.zncm.jmxandroid.hook.HookAActivity;
import com.zncm.jmxandroid.mykotlin.MyKotlinDemo;
import com.zncm.jmxandroid.mykotlin.MyKotlinListView;
import com.zncm.jmxandroid.os.AudioAc;
import com.zncm.jmxandroid.os.BehaviorActivity;
import com.zncm.jmxandroid.os.BottomDlgActivity;
import com.zncm.jmxandroid.os.DlgActivity;
import com.zncm.jmxandroid.os.MyHandlerAc;
import com.zncm.jmxandroid.os.PaperDetailsActivity;
import com.zncm.jmxandroid.os.java.MyHandlerAcJ;
import com.zncm.jmxandroid.support.FabAc;
import com.zncm.jmxandroid.support.TabLayoutAc;
import com.zncm.jmxandroid.ui.AZViewActivity;
import com.zncm.jmxandroid.ui.BaseViewActivity;
import com.zncm.jmxandroid.ui.ColorpickerviewActivity;
import com.zncm.jmxandroid.ui.GlobalLocalAct;
import com.zncm.jmxandroid.ui.ImgActivity;
import com.zncm.jmxandroid.ui.QQSportStepActivity;
import com.zncm.jmxandroid.ui.RockerViewActivity;
import com.zncm.jmxandroid.ui.SmoothImgActivity;
import com.zncm.jmxandroid.ui.ToastyActivity;
import com.zncm.jmxandroid.ui.UtilsActivity;
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
            case R.id.UtilsActivity:
                startActivity(new Intent(ctx, UtilsActivity.class));
                break;
                case R.id.DlgActivity:
                startActivity(new Intent(ctx, DlgActivity.class));
                break;
            case R.id.RockerViewActivity:
                startActivity(new Intent(ctx, RockerViewActivity.class));
                break;

                case R.id.QQSportStepActivity:
                startActivity(new Intent(ctx, QQSportStepActivity.class));
                break;
            case R.id.Okhttp1Activity:
                startActivity(new Intent(ctx, Okhttp1Activity.class));
                break;
            case R.id.BehaviorActivity:
                startActivity(new Intent(ctx, BehaviorActivity.class));
                break;
            case R.id.PaperDetailsActivity:
                startActivity(new Intent(ctx, PaperDetailsActivity.class));
                break;

            case R.id.BottomDlgActivity:
                startActivity(new Intent(ctx, BottomDlgActivity.class));
                break;
            case R.id.PopListActivity:
                startActivity(new Intent(ctx, PopListActivity.class));
                break;
            case R.id.PicEditAc:
//                startActivity(new Intent(ctx, PicEditAc.class));
                break;
            case R.id.ColorSelViewAc:
                startActivity(new Intent(ctx, ColorSelViewAc.class));
                break;
            case R.id.MyPaintAc:
                startActivity(new Intent(ctx, MyPaintAc.class));
                break;

            case R.id.PicEditActivity:
//                startActivity(new Intent(ctx, PicEditActivity.class));
                break;

            case R.id.GifActivity:
                startActivity(new Intent(ctx, GifActivity.class));
                break;
            case R.id.AudioAc:
                startActivity(new Intent(ctx, AudioAc.class));
                break;


            case R.id.FingerprintIdentifyAc:
                startActivity(new Intent(ctx, FingerprintIdentifyAc.class));
                break;


            case R.id.FabAc:
                startActivity(new Intent(ctx, FabAc.class));
                break;

            case R.id.ZoomControlsAc:
                startActivity(new Intent(ctx, ZoomControlsAc.class));
                break;
            case R.id.TabLayoutAc:
                startActivity(new Intent(ctx, TabLayoutAc.class));
                break;
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
                startActivity(new Intent(ctx, HookAActivity.class));
//                Class<?> myClass = null;
//                try {
//                    myClass = Class.forName("com.zncm.jmxandroid.ui.ColorpickerviewActivity");
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                Intent intent = new Intent(this,myClass);
//                startActivity(intent);
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
//            case R.id.MyActivity:
//                startActivity(new Intent(ctx, MyActivity.class));
//                break;
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
