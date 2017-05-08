package com.zncm.jmxandroid.volley;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.base.MyApp;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jiaomx on 2017/5/3.
 */

public class VolleyDemo extends BaseAc {
    //    https://api.unsplash.com/photos/random?client_id=20c1aa97b359765b805e5049e87295d51ff5f3505a6270d810f6bfaf52eedd9f&w=1920&h=1080&orientation=portrait

    @BindView(R.id.tvVolley)
    TextView tvVolley;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.networkImageView)
    NetworkImageView networkImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleydemo);
        ButterKnife.bind(this);
//        volleyGet();
//        volleyPost();


        volleyImg();


    }

    private void volleyImg() {

        String imgUrl = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
//        String url, Response.Listener<Bitmap> listener, int maxWidth, int maxHeight,
//        Bitmap.Config decodeConfig, Response.ErrorListener errorListener
//        ImageRequest imageRequest = new ImageRequest(imgUrl, new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap response) {
//                if (response != null) {
//                    imageView.setImageBitmap(response);
//                }
//
//            }
//        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Xutils.tShort(error.toString());
//            }
//        });
//        imageRequest.setTag("imgGet");
//        MyApp.getRequestQueue().add(imageRequest);

//        ImageLoader imageLoader = new ImageLoader(MyApp.requestQueue,new MyBitmapCache());
////        final ImageView view,
////        final int defaultImageResId, final int errorImageResId
//        ImageLoader.ImageListener imageListener =ImageLoader.getImageListener(imageView,R.mipmap.ic_launcher,R.mipmap.ic_launcher);
//        imageLoader.get(imgUrl,imageListener);


        ImageLoader imageLoader2 = new ImageLoader(MyApp.requestQueue, new MyBitmapCache());
        networkImageView.setDefaultImageResId(R.mipmap.ic_launcher);
        networkImageView.setErrorImageResId(R.mipmap.ic_launcher);
        networkImageView.setImageUrl(imgUrl, imageLoader2);
    }

    private void volleyPost() {

        //BasicNetwork.performRequest: Unexpected response code 400 for
        String url = "https://api.unsplash.com/photos/random?";
        //?client_id=20c1aa97b359765b805e5049e87295d51ff5f3505a6270d810f6bfaf52eedd9f&w=1920&h=1080&orientation=portrait
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                tvVolley.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvVolley.setText(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
//                client_id=20c1aa97b359765b805e5049e87295d51ff5f3505a6270d810f6bfaf52eedd9f&w=1920&h=1080&orientation=portrait
                Map<String, String> map = new HashMap<>();
                map.put("client_id", "20c1aa97b359765b805e5049e87295d51ff5f3505a6270d810f6bfaf52eedd9f");
                return map;
            }
        };

        request.setTag("volleyPost");
        MyApp.getRequestQueue().add(request);

    }

    private void volleyGet() {
        String url = "https://api.unsplash.com/photos/random?client_id=20c1aa97b359765b805e5049e87295d51ff5f3505a6270d810f6bfaf52eedd9f&w=1920&h=1080&orientation=portrait";
//        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                tvVolley.setText(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                tvVolley.setText(error.toString());
//            }
//        });

//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                tvVolley.setText(response.toString());
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                tvVolley.setText(error.toString());
//            }
//        });
//        jsonObjectRequest.setTag("volleyGet");
//        MyApp.getRequestQueue().add(jsonObjectRequest);


        VolleyRequest.RequestGet(this, url, "volleyGet", new VolleyInterface(this, VolleyInterface.mListener, VolleyInterface.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                tvVolley.setText(result.toString());
            }

            @Override
            public void onMyError(VolleyError result) {
                tvVolley.setText(result.toString());
            }
        });

    }
}
