package com.huida.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.huida.R;
import com.huida.activity.FindProjectActivity;
import com.huida.adapter.MyViewpagerAdapter;
import com.huida.adapter.PopRecycleViewAdapter;
import com.huida.adapter.XiFenRecycleAdapter;
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

    private final FindProjectActivity findProjectActivity;
    private List<String> strings;
    private RecyclerView rl;
    private ViewPager vp_content;
    private ArrayList<BasePager> pagerList;
    private MagicIndicator mMagic_indicator;
    private TextView tv_saixuan;
    private ImageView iv_search;
    private ImageView iv_list;
    private LinearLayout title_label;
    private PopRecycleViewAdapter adapter;

    public JinFenFragment(FindProjectActivity findProjectActivity) {

        super();
        this.findProjectActivity=findProjectActivity;

    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fpj_jingfen_layout,null);
        title_label = (LinearLayout) view.findViewById(R.id.title_label);
        mMagic_indicator = (MagicIndicator) view.findViewById(R.id.magic_indicator);
        vp_content = (ViewPager) view.findViewById(R.id.vp_jingfen_content);
        iv_list = (ImageView) view.findViewById(R.id.iv_fpj_list);
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
        initListener();
    }

    private void initListener() {
        iv_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //展示popupwindow
                initPup();
            }
        });
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
        MyViewpagerAdapter viewPagerAdapter = new MyViewpagerAdapter(mActivity,strings);
        vp_content.setAdapter(viewPagerAdapter);
        vp_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    /**
     * 初始化popupwindow
     */
    public  void  initPup(){
         PopupWindow popupWindow = new PopupWindow(findProjectActivity);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        View contentview = LayoutInflater.from(mActivity).inflate(R.layout.layout_popupwindow_jingfen, null);
        popupWindow.setContentView(contentview);
         RecyclerView rl_popwpwind = (RecyclerView) contentview.findViewById(R.id.rl_popupwind);
        final String[] data={"全部","电子商务","社交","工具","移动应用","O2O","企业服务",
                "全部","电子商务","社交","工具","移动应用","O2O","企业服务"};
        rl_popwpwind.setLayoutManager(new GridLayoutManager(mActivity, 4));


            adapter = new PopRecycleViewAdapter(findProjectActivity, data);
            rl_popwpwind.setAdapter(adapter);
            adapter.setOnItemClickListener(new XiFenRecycleAdapter.OnRecyclerViewItemClickListener() {
                @Override
                public void onItemClick(View view) {

                }

                @Override
                public void onItemLongClick(View view) {

                }

                @Override
                public void onItemClick(View view, int tag) {
                    Toast.makeText(findProjectActivity,data[tag],699).show();
                }
            });

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#eeeeee")));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(title_label);
    }


    /**
     * 获取筛选
     */
    public void  SetSaiXuan(TextView  tv_saixuan){
        this.tv_saixuan=tv_saixuan;

    }
    /**
     * 获取搜索按钮
     */
    public  void  SetSearch(ImageView iv_search){
        this.iv_search=iv_search;
    }

}
