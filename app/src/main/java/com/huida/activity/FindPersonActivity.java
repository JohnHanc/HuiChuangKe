package com.huida.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.huida.R;
import com.huida.adapter.FindPersonViewPagerAdapter;
import com.zaaach.citypicker.CityPickerActivity;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.Arrays;
import java.util.List;


/**
 * Created by liling on 2017/9/24.
 */

public class FindPersonActivity extends BaseActivity implements View.OnClickListener {

    private static final int REQUEST_CODE_PICK_CITY = 0;
    //添加tab数据
    private String[] titles = new String[]{"全部", "技术合伙人", "营销合伙人", "运营合伙人", "韩超宇"};
    private List<String> mDataList = Arrays.asList(titles);


    private MagicIndicator mMagic_indicator;
    private ViewPager mView_pager;
    private TextView mTv_citylocation;
    private ImageButton mIb_displayall;
    private GridView mPop_gv_all;
    private TextView mTv_showAllpop;
    private TextView mTv;
    private ShowPopAllGridView mShowPopAllGridViewAdapter;
    private int mLastPosition = -1;
    private PopupWindow mPopupWindow;


//添加laeble

    @Override
    protected int getLayoutId() {
        return R.layout.activity_findperson;
    }

    @Override
    public void initView() {
        mMagic_indicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        mView_pager = (ViewPager) findViewById(R.id.view_pager);
        mTv_citylocation = (TextView) findViewById(R.id.tv_citylocation);
        mIb_displayall = (ImageButton) findViewById(R.id.ib_displayall);
        mTv_citylocation.setOnClickListener(this);
        mIb_displayall.setOnClickListener(this);
    }

    private void initMagicIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setSkimOver(true);

        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                ClipPagerTitleView clipPagerTitleView = new ClipPagerTitleView(context);
                clipPagerTitleView.setText(mDataList.get(index));
                //
                clipPagerTitleView.setTextColor(Color.parseColor("#444444"));
                clipPagerTitleView.setClipColor(Color.parseColor("#30a7fd"));
                clipPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mView_pager.setCurrentItem(index);
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
        ViewPagerHelper.bind(mMagic_indicator, mView_pager);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                mTv_citylocation.setText(city);
            }
        }
    }

    @Override
    public void initData() {
        initMagicIndicator();
        initViewPager();
    }

    @Override
    protected void initLisitenr() {

    }

    private void initViewPager() {
        FindPersonViewPagerAdapter viewPagerAdapter = new FindPersonViewPagerAdapter(mDataList, this);
        mView_pager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_displayall:
                showPopupWindow();
                break;
            case R.id.tv_citylocation:
                startActivityForResult(new Intent(FindPersonActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;

        }
    }

    private void showPopupWindow() {
        mPopupWindow = new PopupWindow(this);
        mPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(this).inflate(R.layout.layout_popupwindow, null);

        mPop_gv_all = (GridView) view.findViewById(R.id.gv_all);
        mShowPopAllGridViewAdapter = new ShowPopAllGridView();
        mPop_gv_all.setAdapter(mShowPopAllGridViewAdapter);
        mPop_gv_all.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mShowPopAllGridViewAdapter.notifyDataSetChanged();
                if (mLastPosition != -1) {
                    parent.getChildAt(mLastPosition).setSelected(false);
                }
                parent.getChildAt(position).setSelected(true);
                mLastPosition = position;
                mView_pager.setCurrentItem(position);
                mPopupWindow.dismiss();
            }
        });
        mPopupWindow.setContentView(view);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAsDropDown(mIb_displayall);
    }


    class ShowPopAllGridView extends BaseAdapter {


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
            convertView = LayoutInflater.from(FindPersonActivity.this).inflate(R.layout.gridview_popitem, null);

            mTv_showAllpop = (TextView) convertView.findViewById(R.id.tv_showAllpop);
            mTv_showAllpop.setText("电子商务啊");

            if (position == mLastPosition) {
                mTv_showAllpop.setSelected(true);
                mLastPosition = position;
            }
            return convertView;
        }
    }

}



