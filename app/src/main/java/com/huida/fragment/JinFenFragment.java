package com.huida.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;


import com.huida.R;
import com.huida.activity.FindProjectActivity;
import com.huida.pager.BasePager;
import com.huida.pager.ContentDataPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liling on 2017/9/25.
 */

public class JinFenFragment extends BaseFragment {

    private List<String> strings;
    private RecyclerView rl;
    private ViewPager vp_content;
    private ArrayList<BasePager> pagerList;
    private MagicIndicator mMagic_indicator;

    public JinFenFragment(FindProjectActivity findProjectActivity) {
        super();

    }



    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fpj_jingfen_layout,null);
        mMagic_indicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        vp_content = (ViewPager) view.findViewById(R.id.vp_jingfen_content);
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        strings = new ArrayList<>();
        strings.add("全部");
        strings.add("电子商务");
        strings.add("社交");
        strings.add("工具");
        strings.add("移动应用");
        strings.add("O2O");
        strings.add("企业服务");
        strings.add("全部");
        strings.add("电子商务");
        strings.add("社交");
        strings.add("工具");
        strings.add("移动应用");
        strings.add("O2O");
        strings.add("企业服务");
        pagerList = new ArrayList<>();
        for (int i = 0; i <strings.size() ; i++) {
            pagerList.add(new ContentDataPager(mActivity));
        }
        Log.e("iii", "initData: "+pagerList.size() );
        vp_content.setCurrentItem(0);
        //初始化引导label
        initMagicIndicator();
        //初始化viewpager
        initViewPager();
    }
   //添加laeble
    private void initMagicIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setSkimOver(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return strings == null ? 0 : strings.size();
            }
            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(strings.get(index));
                //
                clipPagerTitleView.setTextColor(Color.parseColor("#444444"));
                clipPagerTitleView.setClipColor(Color.parseColor("#30a7fd"));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vp_content.setCurrentItem(index);
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
        mMagic_indicator.setNavigator(commonNavigator);
        //绑定viewpager
        ViewPagerHelper.bind(mMagic_indicator, vp_content);
    }
    private void initViewPager() {
        MyViewpagerAdapter viewPagerAdapter = new MyViewpagerAdapter();
        vp_content.setAdapter(viewPagerAdapter);
        vp_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //pagerList.get(position).initData();
            }

            @Override
            public void onPageSelected(int position) {
                pagerList.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private class MyViewpagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return  pagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            BasePager pager = pagerList.get(position);

            View view = pager.initView();
            Log.e("iiii", "instantiateItem: "+view );
            Log.e("iii", "instantiateItem: "+position );

            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
