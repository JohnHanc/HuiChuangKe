package com.huida.pager;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.huida.R;
import com.huida.bean.JinFenDataBean;
import com.huida.view.DividerItemDecoration;


import java.util.ArrayList;

/**
 * Created by liling on 2017/9/25.
 */

public class ContentDataPager extends BasePager {

    private RecyclerView rl_item;
    private ArrayList<String> list;

    public ContentDataPager(Activity mActivity) {
        super(mActivity);
        initView();
        initData();

    }

    @Override
    public View initView() {
        Log.e("ceshi", "initView: "+"initview" );
        rl_item = (RecyclerView) View.inflate(mActivity, R.layout.jingfen_vp_rl_layout, null);
        return rl_item;
    }

    @Override
    public void initData() {
        Log.e("ceshi", "initData: "+"data" );
        list = new ArrayList<>();
        list.add("iii");
        list.add("iii");
        list.add("iii");
        list.add("iii");
        list.add("iii");
        list.add("iii");
        JinFenDataBean jinFenDataBean = new JinFenDataBean();
        ArrayList<JinFenDataBean> BeenList = new ArrayList<>();
        rl_item.setLayoutManager(new LinearLayoutManager(mActivity));
       // rl_item.setAdapter(new RecycleItemAdapter(R.layout.findproject_rlview_item,list));
        rl_item.setAdapter(new RecycleItemAdapter());
        rl_item.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.HORIZONTAL_LIST, R.mipmap.line_gray));
    }

    private class RecycleItemAdapter extends RecyclerView.Adapter<RecycleItemAdapter.Holder> {
        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.findproject_rlview_item, parent,false);

            return new Holder(view);
        }
        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.item_title.setText(list.get(position));

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class Holder extends  BaseViewHolder{

            private final TextView item_title;
            private final TextView item_brief;

            public Holder(View view) {
                super(view);
                item_title = (TextView) itemView.findViewById(R.id.rl_item_title);
                item_brief = (TextView) itemView.findViewById(R.id.rl_item_brief);
            }
        }
    }








    //回调接口
   /* public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View CircleImageView.java);
        void onItemLongClick(View CircleImageView.java);
    }*/


   /* private class RecycleItemAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
        public RecycleItemAdapter(@LayoutRes int layoutResId, @Nullable ArrayList<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }*/
}
