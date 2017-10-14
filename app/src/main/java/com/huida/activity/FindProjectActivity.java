package com.huida.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.huida.R;
import com.huida.fragment.BaseFragment;
import com.huida.fragment.JinFenFragment;
import com.huida.fragment.XiFenFragment;

import java.util.ArrayList;

/**
 * Created by liling on 2017/9/24.
 */

public  class FindProjectActivity extends BaseActivity {

    private FrameLayout fg_fpj;
    private RadioGroup rg_title;
    private TextView tv_select;
    private ImageView iv_search;
    private ArrayList<BaseFragment> fragmentList;
    private FragmentTransaction transaction;
    private RadioButton rb_jinfen;
    private RadioButton rb_xifen;

    @Override
    protected int getLayoutId() {
        return R.layout.findproject_layout;
    }

    @Override
    public void initView() {
        fg_fpj = (FrameLayout) findViewById(R.id.fpj_fl);
        rg_title = (RadioGroup) findViewById(R.id.rg_fpj_title);
        tv_select = (TextView) findViewById(R.id.tv_jingfen_saixuan);
        iv_search = (ImageView) findViewById(R.id.iv_jingfen_search);
        rb_jinfen = (RadioButton) findViewById(R.id.rb_fpj_jinfen);
        rb_xifen = (RadioButton) findViewById(R.id.rb_fpj_xifen);


    }


    @Override
    protected void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new JinFenFragment(this));
        fragmentList.add(new XiFenFragment(this));
        /**
         * 传筛选和搜索
         *
         */
        JinFenFragment jf = this.getJingFen();
        jf.SetSaiXuan(tv_select);
        jf.SetSearch(iv_search);


        FragmentManager manager = this.getFragmentManager();
        transaction = manager.beginTransaction();

        transaction.replace(R.id.fpj_fl,fragmentList.get(1));
        transaction.commit();
        initLisitenr();
    }

    @Override
    protected void initLisitenr() {
        Log.e("liling", "initLisitenr: "+"rgggg" );
        rg_title.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                transaction = FindProjectActivity.this.getFragmentManager().beginTransaction();
                switch (i){
                    case  R.id.rb_fpj_jinfen:
                        Log.e("liling", "initLisitenr: "+"rg1" );
                        transaction.replace(R.id.fpj_fl,fragmentList.get(0));
                        break;
                    case  R.id.rb_fpj_xifen:
                        Log.e("liling", "initLisitenr: "+"rg2" );
                        transaction.replace(R.id.fpj_fl,fragmentList.get(1));
                        break;
                    default:
                        break;
                }
                transaction.commit();

            }
        });

}

    /**
     * 获取精分fragment的对象
     */
    public JinFenFragment  getJingFen(){
        JinFenFragment fragment = (JinFenFragment) fragmentList.get(0);

        return  fragment;
    }
}