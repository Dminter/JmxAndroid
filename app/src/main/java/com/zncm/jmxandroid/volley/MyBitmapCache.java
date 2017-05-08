package com.zncm.jmxandroid.volley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by jiaomx on 2017/5/7.
 */

public class MyBitmapCache implements ImageLoader.ImageCache {
    public LruCache<String, Bitmap> cache;
    public int max = 20 * 1024 * 1024;

    public MyBitmapCache() {
        cache = new LruCache<String, Bitmap>(max) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };

    }

    @Override
    public Bitmap getBitmap(String url) {
        return cache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        cache.put(url, bitmap);
    }
}
