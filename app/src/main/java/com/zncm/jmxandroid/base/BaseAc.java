package com.zncm.jmxandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zncm.jmxandroid.R;

/**
 * Created by jiaomx on 2017/5/3.
 */

public abstract class BaseAc extends AppCompatActivity {

 public    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResource() != -1) {
            setContentView(getLayoutResource());
        }
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setSubtitle(getLocalClassName());
            toolbar.setTitleTextColor( getResources().getColor(R.color.material_light_white));
            toolbar.setNavigationIcon(R.drawable.md_nav_back);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return false;
    }

    protected abstract int getLayoutResource();
}
