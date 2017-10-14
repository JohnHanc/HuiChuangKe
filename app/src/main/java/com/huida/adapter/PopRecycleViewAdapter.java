package com.huida.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chad.library.adapter.base.BaseViewHolder;
import com.huida.R;

/**
 * Created by liling on 2017/10/2.
 */

public class PopRecycleViewAdapter extends RecyclerView.Adapter<PopRecycleViewAdapter.Holder> implements View.OnClickListener,View.OnLongClickListener {
    private final String[] data;
    private final Activity mActivity;




    //自定义监听事件
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view);
        void onItemLongClick(View view);
        void onItemClick(View view, int tag);
    }
    private XiFenRecycleAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(XiFenRecycleAdapter.OnRecyclerViewItemClickListener listener) {
        mOnItemClickListener = listener;
    }
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onItemLongClick(view);
        }
        return false;
    }




    public PopRecycleViewAdapter(Activity mActivity, String[] data) {
        this.mActivity=mActivity;
        this.data=data;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.layout_pop_rl_item, parent, false);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
            holder.bt_item.setText(data[position]);
        //将position保存在itemView的Tag中，以便点击时进行获取
            holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
    class  Holder extends BaseViewHolder{

        private final Button bt_item;

        public Holder(View view) {
            super(view);
            bt_item = (Button) view.findViewById(R.id.bt_item);
        }
    }
}
