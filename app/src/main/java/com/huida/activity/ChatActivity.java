package com.huida.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.huida.R;
import com.huida.fragment.DyMsgFragment;
import com.huida.fragment.DynamicFragment;

/**
 * Created by Liu on 2017/10/15.
 */

public class ChatActivity extends BaseActivity {

    private ImageView back;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {
        back = (ImageView) findViewById(R.id.iv_chat_back);

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
