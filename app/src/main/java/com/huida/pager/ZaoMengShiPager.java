package com.huida.pager;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.huida.R;
import com.huida.adapter.CityRecycleAdapter;
import com.huida.adapter.XiFenRecycleAdapter;

import com.huida.utils.CityDataBean;
import com.huida.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by liling on 2017/9/30.
 */

public class ZaoMengShiPager extends BasePager {

    private static final String TAG = "li";
    //HashMap<String, String> provinceHash = new HashMap<String, String>();
  //  String[] provinceString = new String[34];
  //  HashMap<String, String> cityHash = new HashMap<String, String>();
    String[] cityString;

    String cityNo = null;// 最重要的参数，选中的城市的cityNo
    @BindView(R.id.tv_all)
    TextView tvAll;
    @BindView(R.id.tv_zijin)
    TextView tvZijin;
    @BindView(R.id.tv_zaohuan)
    TextView tvZaohuan;
    @BindView(R.id.rl_provinces)
    RecyclerView rlProvinces;
    @BindView(R.id.rl_city)
    RecyclerView rlCity;
    private ArrayList<String> provinces;
    private XiFenRecycleAdapter provincesadapter;
    private CityDataBean cityData;
    private String file;

    public ZaoMengShiPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.xinfen_vp_layout, null);
        ButterKnife.bind(this, view);
        ViewGroup.LayoutParams layoutParams = rlProvinces.getLayoutParams();
        Log.e(TAG, "initView: layoutParams==="+layoutParams );
        layoutParams.width = mActivity.getWindowManager().getDefaultDisplay().getWidth()/3;
        Log.e(TAG, "initView: width==="+mActivity.getWindowManager().getDefaultDisplay().getWidth()/3 );
        rlProvinces.setLayoutParams(layoutParams);
        return view;
    }

    @Override
    public void initData() {
        //默认全部
        tvAll.setSelected(true);
        Log.e(TAG, "initData: iiii");
        //获取city数据
        cityData = new CityDataBean();
        file = cityData.readFile(mActivity);
        //获取省份
        provinces = cityData.getProvinces(file);

        Log.d(TAG, "initData: " + provinces.size());
        initAdapter();

    }

    @Override
    public void initListener() {
        super.initListener();

    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Log.d(TAG, "initAdapter: " + rlProvinces);
        rlProvinces.setLayoutManager(linearLayoutManager);
        if (provincesadapter == null) {
            provincesadapter = new XiFenRecycleAdapter(mActivity, provinces);
            rlProvinces.setAdapter(provincesadapter);
            // 省份adapter的条目点击事件
           provincesadapter.setOnItemClickListener(new XiFenRecycleAdapter.OnRecyclerViewItemClickListener() {

                @Override
                public void onItemClick(View view) {

                }

                @Override
                public void onItemLongClick(View view) {


                }
                @Override
                public void onItemClick(View view, int tag) {
                  //  Toast.makeText(mActivity, provinces.get(tag) + "被点击了", 600).show();
                    int id = view.getId();
                    switch (id){

                    }
                    Log.e(TAG, "onItemClick: id"+id );
                    //获取城市
                    String provinceName = provinces.get(tag);
                    Log.e(TAG, "onItemClick:  省份 "+provinceName );
                    String guid = cityData.provinceHash.get(provinceName);
                    cityString = cityData.getCitys(guid, file);
                    Log.e(TAG, "onItemClick:   pn"+provinceName );
                    Log.e(TAG, "onItemClick: guid "+guid );
                    Log.e(TAG, "onItemClick:  citys"+cityString );


                    // 省被选中后，初始化城市recycleview
                    initCityAdapter();

                }
            });



    } else {
        provincesadapter.notifyDataSetChanged();
    }


        //设置分割线
      //  rlProvinces.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.BOTH_SET));
        rlProvinces.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.BOTH_SET,2, mActivity.getResources().getColor(R.color.provinces_press)));

    }

    private void initCityAdapter() {
        rlCity.setLayoutManager(new GridLayoutManager(mActivity,3));
        rlCity.setAdapter(new CityRecycleAdapter(mActivity,cityString));
    }


    @OnClick({R.id.tv_all, R.id.tv_zijin, R.id.tv_zaohuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_all:
                Toast.makeText(mActivity,view.getId()+"1",600).show();
                tvZijin.setSelected(false);
                tvZaohuan.setSelected(false);
                tvAll.setSelected(true);

                //initAdapter();
                break;
            case R.id.tv_zijin:
                Toast.makeText(mActivity,view.getId()+"2",600).show();
                tvAll.setSelected(false);
                tvZaohuan.setSelected(false);
                tvZijin.setSelected(true);

                break;
            case R.id.tv_zaohuan:
                Toast.makeText(mActivity,view.getId()+"3",600).show();
                tvAll.setSelected(false);
                tvZijin.setSelected(false);
                tvZaohuan.setSelected(true);
                break;

        }
    }
}

/**
 * recycleview的适配器
 */




