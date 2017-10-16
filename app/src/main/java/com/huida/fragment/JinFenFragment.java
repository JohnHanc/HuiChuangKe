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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.huida.R;
import com.huida.activity.DuttActivity;
import com.huida.activity.FindPersonActivity;
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

    private static final String TAG = "liling";
    private final FindProjectActivity findProjectActivity;
    private List<String> strings;
    private RecyclerView rl;
    private ViewPager vp_content;
    private ArrayList<BasePager> pagerList;
    private MagicIndicator mMagic_indicator;

    private ImageView iv_search;
    private ImageView iv_list;
    private LinearLayout title_label;
    private PopRecycleViewAdapter adapter;
    private  int mLastPosition=-1;
    private ShowPopAllGridView showPopAllGridView;

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
            pagerList.add(new ContentDataPager(findProjectActivity));
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
        CommonNavigator commonNavigator = new CommonNavigator(findProjectActivity);
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
        MyViewpagerAdapter viewPagerAdapter = new MyViewpagerAdapter(findProjectActivity,strings);
        vp_content.setAdapter(viewPagerAdapter);
        vp_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //pagerList.get(position).initData();


            }

            @Override
            public void onPageSelected(int position) {
                mLastPosition = position;
                showPopAllGridView.notifyDataSetChanged();

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
         final PopupWindow popupWindow = new PopupWindow(findProjectActivity);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        View contentview = LayoutInflater.from(mActivity).inflate(R.layout.layout_popupwindow_jingfen, null);
        popupWindow.setContentView(contentview);
         GridView rl_popwpwind = (GridView) contentview.findViewById(R.id.gv_all);
        final String[] data={"全部","电子商务","社交","工具","移动应用","O2O","企业服务",
                "全部","电子商务","社交","工具","移动应用","O2O","企业服务"};
//        final GridLayoutManager layoutManager = new GridLayoutManager(mActivity, 4);
//        rl_popwpwind.setLayoutManager(layoutManager);
          //  adapter = new PopRecycleViewAdapter(findProjectActivity, data);
            showPopAllGridView = new ShowPopAllGridView(data);
            rl_popwpwind.setAdapter(showPopAllGridView);
            rl_popwpwind.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if (mLastPosition != -1) {
                        adapterView.getChildAt(mLastPosition).setSelected(false);
                    }
                    adapterView.getChildAt(i).setSelected(true);
                    mLastPosition = i;
                    vp_content.setCurrentItem(i);
                    popupWindow.dismiss();
                }
            });

        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#eeeeee")));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(title_label);
    }

    class ShowPopAllGridView extends BaseAdapter {


        private final String[] data;
        private TextView mTv_showAllpop;

        public ShowPopAllGridView(String[] data) {
            this.data=data;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(findProjectActivity).inflate(R.layout.gridview_popitem, null);

            mTv_showAllpop = (TextView) convertView.findViewById(R.id.tv_showAllpop);
            mTv_showAllpop.setText(data[position]);


            if (position == mLastPosition) {
                mTv_showAllpop.setSelected(true);
                mLastPosition = position;
            }
            return convertView;
        }
    }

    /**
     * 获取搜索按钮
     */
    public  void  SetSearch(ImageView iv_search){
        this.iv_search=iv_search;
    }

}
