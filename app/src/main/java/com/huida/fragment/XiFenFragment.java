package com.huida.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huida.R;
import com.huida.activity.FindProjectActivity;
import com.huida.pager.BasePager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

/**
 * Created by liling on 2017/9/25.
 */

public class XiFenFragment extends BaseFragment {

    private MagicIndicator indicator;
    private ViewPager xifen_vp;
    private String[] titils;

    public XiFenFragment(FindProjectActivity findProjectActivity) {
        super();
    }


    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fpj_xifen_layout, null);
        indicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        xifen_vp = (ViewPager) view.findViewById(R.id.xifen_vp);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        titils = new String[]{"造梦师","造梦师","造梦师","造梦师"};
        initMagicIndicator();
        initViewPager();

    }
    //添加laeble
    private void initMagicIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setSkimOver(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {

                return titils== null ? 0 : titils.length;
            }
            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(titils[index]);
                //
                clipPagerTitleView.setTextColor(Color.parseColor("#444444"));
                clipPagerTitleView.setClipColor(Color.parseColor("#30a7fd"));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        xifen_vp.setCurrentItem(index);
                        //加载对应数据

                    }
                });
                return clipPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }


        });
       indicator.setNavigator(commonNavigator);
        //绑定viewpager
        ViewPagerHelper.bind(indicator, xifen_vp);
    }
    private void initViewPager() {
        MyViewpagerAdapter viewPagerAdapter = new MyViewpagerAdapter();
        xifen_vp.setAdapter(viewPagerAdapter);
        xifen_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //pagerList.get(position).initData();
            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyViewpagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {

            return  4;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = View.inflate(mActivity,R.layout.xinfen_vp_layout,null);

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
