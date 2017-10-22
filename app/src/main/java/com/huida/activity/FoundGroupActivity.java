package com.huida.activity;

import android.view.View;
import android.widget.ImageView;

import com.huida.R;

/**
 * Created by Liu on 2017/10/21.
 */

public class FoundGroupActivity extends BaseActivity {

    private ImageView back;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_foundgroup;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {

        back = (ImageView) findViewById(R.id.iv_found_back);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 初始化监听器
     */
    @Override
    protected void initLisitenr() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
