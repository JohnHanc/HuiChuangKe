package com.huida.activity;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.huida.R;

/**
 * Created by Liu on 2017/10/21.
 */

public class ReplayReviewActivity extends BaseActivity {

    private Button cancel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_replay_review;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {
        cancel = (Button) findViewById(R.id.bt_replay_cancel);
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

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
