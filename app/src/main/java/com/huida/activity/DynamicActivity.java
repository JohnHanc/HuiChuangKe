package com.huida.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.huida.R;
import com.huida.fragment.DyMsgFragment;
import com.huida.fragment.DyStateFragment;


/**
 * Created by liling on 2017/9/24.
 */

public  class DynamicActivity extends BaseActivity {

    private RadioButton rb_dy_state;
    private RadioButton rb_dy_msg;
    private FrameLayout fl_dy;
    private RadioGroup rg_dy;
    private FragmentManager manager=getFragmentManager();;



    @Override
    protected int getLayoutId() {
        return R.layout.dymic;
    }

    @Override
    public void initView() {
        rg_dy = (RadioGroup) findViewById(R.id.rg_dy);
        rb_dy_state = (RadioButton) findViewById(R.id.rb_dy_state);
        rb_dy_msg = (RadioButton) findViewById(R.id.rb_dy_msg);
        fl_dy = (FrameLayout) findViewById(R.id.fl_dy);

    }

    @Override
    protected void initData() {

        FragmentTransaction ft = manager.beginTransaction();

        rg_dy.check(R.id.rb_dy_state);
        ft.replace(R.id.fl_dy, new DyStateFragment()).commit();

    }

    @Override
    protected void initLisitenr() {
        rg_dy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentTransaction ft = manager.beginTransaction();
                switch (checkedId){
                    case R.id.rb_dy_state:
                        ft.replace(R.id.fl_dy,new DyStateFragment());
                        break;
                    case R.id.rb_dy_msg:
                        ft.replace(R.id.fl_dy,new DyMsgFragment());
                        break;
                }
                ft.commit();
            }
        });

    }


}
