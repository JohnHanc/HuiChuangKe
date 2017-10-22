package com.huida.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huida.R;
import com.huida.bean.ReViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2017/10/21.
 */

public class ZanActivity extends BaseActivity {

    private ImageView back;
    private RecyclerView rv_zan;
    private List<ReViewBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zan;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {

        back = (ImageView)findViewById(R.id.iv_review_back);
        rv_zan = (RecyclerView)findViewById(R.id.rv_zan);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

        rv_zan.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list.add(new ReViewBean("韩东君"+i));
        }

        zanAdapter adapter = new zanAdapter(R.layout.item_zan, list);
        rv_zan.setAdapter(adapter);
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

    class zanAdapter extends BaseQuickAdapter<ReViewBean,BaseViewHolder> {

        public zanAdapter(@LayoutRes int layoutResId, @Nullable List<ReViewBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ReViewBean item) {

            helper.setText(R.id.tv_zan_name,item.name).setText(R.id.tv_zan_name2,item.name);


            helper.setOnClickListener(R.id.bt_zan_replay, new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ZanActivity.this, ReplayReviewActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
