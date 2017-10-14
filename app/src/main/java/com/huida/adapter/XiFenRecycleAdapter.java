package com.huida.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.huida.R;

import java.util.ArrayList;

/**
 * Created by liling on 2017/10/1.
 */

public class XiFenRecycleAdapter extends RecyclerView.Adapter<XiFenRecycleAdapter.Hodler> implements View.OnClickListener,View.OnLongClickListener {
    private final Activity mActivity;
    private final ArrayList<String> provinces;



    //自定义监听事件
    public static interface OnRecyclerViewItemClickListener {
         void onItemClick(View view);
        void onItemLongClick(View view);
        void onItemClick(View view, int tag);
    }
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
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




    public  XiFenRecycleAdapter(Activity mActivity, ArrayList<String> provinces){
        this.mActivity=mActivity;
        this.provinces=provinces;

    }

    @Override
    public Hodler onCreateViewHolder(ViewGroup parent, int viewType) {
        Button view = (Button) LayoutInflater.from(mActivity).inflate(R.layout.xifen_rlview_item, parent, false);
        view.setOnClickListener(this);
        return new Hodler(view);
    }

    @Override
    public void onBindViewHolder(final Hodler holder, int position) {

        holder.bt_text.setText(provinces.get(position));

        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return  provinces.size();
    }

    class Hodler extends RecyclerView.ViewHolder {

        private  Button bt_text;

        public Hodler(View itemView) {
            super(itemView);
            bt_text = (Button) itemView.findViewById(R.id.bt_text);
        }
    }
}
