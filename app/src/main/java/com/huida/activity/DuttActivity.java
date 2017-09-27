package com.huida.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.huida.R;


/**
 * Created by liling on 2017/9/24.
 */

public  class DuttActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.butt_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initLisitenr() {

    }
}
