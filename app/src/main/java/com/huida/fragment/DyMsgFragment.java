package com.huida.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huida.R;
import com.huida.activity.ChatActivity;
import com.huida.activity.DynamicActivity;
import com.huida.activity.ReViewActivity;
import com.huida.activity.ZanActivity;
import com.huida.bean.IconBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2017/9/17.
 */

public class DyMsgFragment extends BaseFragment {


    private RecyclerView rv_dy_msg;
    private ArrayList<IconBean> list;
    private FragmentManager manager;
    private LinearLayout mine;
    private LinearLayout review;
    private LinearLayout zan;


    @Override
    public View initView() {

        View view = View.inflate(mActivity, R.layout.fragment_dy_msg, null);
        rv_dy_msg = (RecyclerView) view.findViewById(R.id.rv_dy_msg);
        mine = (LinearLayout) view.findViewById(R.id.ll_dymsg_mine);
        review = (LinearLayout) view.findViewById(R.id.ll_dymsg_review);
        zan = (LinearLayout) view.findViewById(R.id.ll_dymsg_zan);
        return view;
    }

    @Override
    public void initData() {
        rv_dy_msg.setLayoutManager(new LinearLayoutManager(mActivity));
        list = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            list.add(new IconBean(i,"jjj"));
        }
        manager = getFragmentManager();

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mActivity, ReViewActivity.class);
                startActivity(intent);
            }
        });
        zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mActivity, ZanActivity.class);
                startActivity(intent);

            }
        });

       DmRvAdapter adapter = new DmRvAdapter(R.layout.item_dymsg, list);
        rv_dy_msg.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent=new Intent(mActivity, ChatActivity.class);
                startActivity(intent);

            }
        });

    }

    class   DmRvAdapter    extends BaseQuickAdapter<IconBean,BaseViewHolder>{

         public DmRvAdapter(@LayoutRes int layoutResId, @Nullable List<IconBean> data) {
             super(layoutResId, data);
         }

         @Override
         protected void convert(BaseViewHolder helper, IconBean item) {

             helper.setText(R.id.tv_dymsg_name,item.iName);

         }
    }
}
