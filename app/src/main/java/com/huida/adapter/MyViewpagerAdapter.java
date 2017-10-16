package com.huida.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.huida.pager.BasePager;
import com.huida.pager.ContentDataPager;

import java.util.List;

/**
 * Created by liling on 2017/10/2.
 */

public class MyViewpagerAdapter extends PagerAdapter{


    private final Activity mActivity;
    private final List<String> strings;

    public MyViewpagerAdapter(Activity mActivity, List<String> strings) {
        this.mActivity=mActivity;
        this.strings=strings;
    }

    @Override
        public int getCount() {
            return  strings.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ContentDataPager contentDataPager = new ContentDataPager(mActivity);
            View view = contentDataPager.initView();

            container.addView(view);
            contentDataPager.initData();

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }


