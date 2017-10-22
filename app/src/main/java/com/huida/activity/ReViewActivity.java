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

public class ReViewActivity extends BaseActivity {

    private ImageView back;
    private RecyclerView rv_review;
    private List<ReViewBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_review;
    }

    /**
     * 初始化View
     */
    @Override
    public void initView() {

        back = (ImageView)findViewById(R.id.iv_review_back);
        rv_review = (RecyclerView)findViewById(R.id.rv_review);
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

        rv_review.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list.add(new ReViewBean("韩东君"+i));
        }

        reViewAdapter adapter = new reViewAdapter(R.layout.item_review, list);
        rv_review.setAdapter(adapter);
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

    class reViewAdapter extends BaseQuickAdapter<ReViewBean,BaseViewHolder> {

        public reViewAdapter(@LayoutRes int layoutResId, @Nullable List<ReViewBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ReViewBean item) {

            helper.setText(R.id.tv_review_name2,item.name).setText(R.id.tv_review_name,item.name);

            helper.setOnClickListener(R.id.bt_review_replay, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ReViewActivity.this, ReplayReviewActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}
