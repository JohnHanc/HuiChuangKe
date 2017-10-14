package com.huida.adapter;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.huida.pager.BasePager;
import com.huida.pager.ZaoMengShiPager;

/**
 * Created by liling on 2017/10/2.
 */

public class XiFenViewPager  extends PagerAdapter {

    private final Activity mActivity;
    private final String[] titils;

    public XiFenViewPager(Activity mActivity, String[] titils) {
        this.mActivity=mActivity;
        this.titils=titils;
    }

    @Override
        public int getCount() {

            return  titils.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            ZaoMengShiPager zaoMengShiPager = new ZaoMengShiPager(mActivity);
            View view = zaoMengShiPager.initView();
            container.addView(view);
            //预加载
            zaoMengShiPager.initData();
            return view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

