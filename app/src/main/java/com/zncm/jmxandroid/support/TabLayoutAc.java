package com.zncm.jmxandroid.support;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.utils.Xutils;

/**
 * Created by jiaomx on 2017/5/23.
 */

public class TabLayoutAc extends BaseAc {

    TabLayout mTabLayout;
    TabLayout mTabLayout2;
    TabLayout mTabLayout3;
    ViewPager viewPager;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTabLayout =(TabLayout) findViewById(R.id.mTabLayout);
        mTabLayout.addTab(mTabLayout.newTab().setText("tab 1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab 2").setIcon(R.drawable.ic_check));
        mTabLayout.addTab(mTabLayout.newTab().setText("tab 3"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 4"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 5"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 6"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 7"));
        for (int i = 8; i <20 ; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText("Tab "+i));
        }
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                Xutils.debug("onScrollChange::"+scrollX+" "+scrollY+" "+oldScrollX);
            }
        });
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Xutils.debug("onTabSelected::"+tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Xutils.debug("onTabUnselected::"+tab.getText());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Xutils.debug("onTabReselected::"+tab.getText());
            }
        });




        /**
         *结合viewPager使用才是精华
         */

        viewPager =(ViewPager)findViewById(R.id.viewPager);
        mTabLayout2 = (TabLayout)findViewById(R.id.mTabLayout2);

        final int tabCount = 8;
        for (int i = 0; i < tabCount; i++) {
            mTabLayout2.addTab(mTabLayout2.newTab().setText("viewPager Tab "+i));
        }
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new MyFt();
            }

            @Override
            public int getCount() {
                return tabCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "TAB"+position;
            }
        });
        mTabLayout2.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout2.setupWithViewPager(viewPager);


        LinearLayout linearLayout = (LinearLayout)mTabLayout2.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerPadding(20);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this, R.drawable.divider_vertical));




        LinearLayout mLinearLayout = (LinearLayout)findViewById(R.id.mLinearLayout);
        mLinearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        mLinearLayout.setDividerPadding(20);
        mLinearLayout.setDividerDrawable(ContextCompat.getDrawable(this, R.drawable.divider_vertical));

        mTabLayout3 = (TabLayout)findViewById(R.id.mTabLayout3);


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_tablayoutac;
    }
}
