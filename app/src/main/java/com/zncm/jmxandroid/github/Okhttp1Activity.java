package com.zncm.jmxandroid.github;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.utils.Xutils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * java.lang.RuntimeException: Unable to start activity ComponentInfo{com.zncm.jmxandroid/com.zncm.jmxandroid.github.Okhttp1Activity}:
 * android.os.NetworkOnMainThreadException
 *
 *
 * new Handler().post(new Runnable() {
 *
 * @Override public void run() { String outStr = getData(url); if (Xutils.isNotEmptyOrNull(outStr))
 * { textView.setText(outStr); } } }); 后问题依然存在 android.os.NetworkOnMainThreadException
 */
public class Okhttp1Activity extends BaseAc {
    Context ctx;
    OkHttpClient client;
    String url = "http://api.douban.com/v2/movie/top250";
    TextView textView;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
/**
 *豆瓣电影 top250
 *  http://api.douban.com/v2/movie/top250
 */

        client = new OkHttpClient();
        textView = (TextView) findViewById(R.id.textView);


//        handler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//
//                Xutils.debug("msg:"+msg);
//
//                if (msg.arg1==1){
//                    String outStr = msg.toString();
//                    if (Xutils.isNotEmptyOrNull(outStr)) {
//                        textView.setText(outStr);
//                    }
//
//                }
//
//
//            }
//        };
//
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                String outStr = getData(url);
//                Message msg = new Message();
//                msg.obj = outStr;
//                msg.arg1 = 1;
//                handler.sendMessage(msg);
//            }
//        });


//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                /**
//                 *        android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
//                 *             java.lang.RuntimeException: No Looper; Looper.prepare() wasn't called on this thread.
//                 */
//              Looper.prepare();
////                Looper.loop();
//                String outStr = getData(url);
//                Xutils.debug("outStr===>>>"+outStr+" url::"+url);
//                if (Xutils.isNotEmptyOrNull(outStr)) {
//                    textView.setText(outStr);
//                }
//
//            }
//        }.start();
        OkAsyncTask okAsyncTask = new OkAsyncTask();
        okAsyncTask.execute(url);

    }

    private String getData(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    private String postData(String url, String json) {

        try {


            MediaType JSON = MediaType.parse("application/json; charset=utf-8");


            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().toString();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";


    }


    public class OkAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String outStr = "";
                         outStr = getData(url);
//            outStr = postData(url, "");
            Xutils.debug("outStr===>>>" + outStr + " url::" + url);


            return outStr;
        }


        @Override
        protected void onPostExecute(String outStr) {
            super.onPostExecute(outStr);
            if (Xutils.isNotEmptyOrNull(outStr)) {
                textView.setText(outStr);
            }

        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_okhttp1;
    }
}
