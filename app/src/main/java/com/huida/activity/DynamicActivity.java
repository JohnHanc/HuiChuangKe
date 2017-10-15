package com.huida.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.huida.R;
import com.huida.fragment.DyMsgFragment;
import com.huida.fragment.DyStateFragment;
import com.huida.fragment.DynamicFragment;


/**
 * Created by liling on 2017/9/24.
 */

public  class DynamicActivity extends BaseActivity {


    private FrameLayout fl_dy;

    private FragmentManager manager=getFragmentManager();



    @Override
    protected int getLayoutId() {
        return R.layout.dymic;
    }

    @Override
    public void initView() {

        fl_dy = (FrameLayout) findViewById(R.id.fl_dymic);

    }

    @Override
    protected void initData() {

        FragmentTransaction ft = manager.beginTransaction();

        ft.add(R.id.fl_dymic, new DynamicFragment()).commit();

    }

    @Override
    protected void initLisitenr() {

    }


}
