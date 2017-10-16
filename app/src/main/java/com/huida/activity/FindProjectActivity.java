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
        iv_search = (ImageView) findViewById(R.id.iv_jingfen_search);
        rb_jinfen = (RadioButton) findViewById(R.id.rb_fpj_jinfen);
        rb_xifen = (RadioButton) findViewById(R.id.rb_fpj_xifen);


    }


    @Override
    protected void initData() {
        //默认
        rb_jinfen.setSelected(true);
        fragmentList = new ArrayList<>();
        fragmentList.add(new JinFenFragment(this));
        fragmentList.add(new XiFenFragment(this));
        /**
         * 传筛选和搜索
         *
         */
        JinFenFragment jf = this.getJingFen();

        jf.SetSearch(iv_search);

        FragmentManager manager = this.getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fpj_fl,fragmentList.get(0));
        transaction.commit();
        initLisitenr();
    }

    @Override
    protected void initLisitenr() {
        rg_title.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                transaction = FindProjectActivity.this.getFragmentManager().beginTransaction();
                switch (i){
                    case  R.id.rb_fpj_jinfen:
                        transaction.replace(R.id.fpj_fl,fragmentList.get(0));
                         rb_jinfen.setSelected(true);
                        break;
                    case  R.id.rb_fpj_xifen:
                        transaction.replace(R.id.fpj_fl,fragmentList.get(1));
                        rb_xifen.setSelected(true);
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