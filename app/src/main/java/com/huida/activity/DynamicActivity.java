package com.huida.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

import com.huida.R;
import com.huida.fragment.DyMsgFragment;
import com.huida.fragment.DyStateFragment;


/**
 * Created by liling on 2017/9/24.
 */

public  class DynamicActivity extends BaseActivity {




    private FragmentManager manager=getFragmentManager();
    private RadioGroup rg_dy;
    private ImageButton found;
    private ImageButton create;


    @Override
    protected int getLayoutId() {
        return R.layout.dymic;
    }

    @Override
    public void initView() {

        rg_dy = (RadioGroup) findViewById(R.id.rg_dy);
        found = (ImageButton) findViewById(R.id.ib_dy_found);
        create = (ImageButton) findViewById(R.id.ib_dy_create);

    }

    @Override
    protected void initData() {

        manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        rg_dy.check(R.id.rb_dy_state);
        ft.replace(R.id.fl_dy,new DyStateFragment()).commit();

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

        found.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DynamicActivity.this, FoundGroupActivity.class);
                startActivity(intent);
            }
        });
    }


}
