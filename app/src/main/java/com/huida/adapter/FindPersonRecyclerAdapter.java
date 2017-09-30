package com.huida.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huida.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Han on 2017/9/20.
 */

public class FindPersonRecyclerAdapter extends RecyclerView.Adapter<FindPersonRecyclerAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    public FindPersonRecyclerAdapter(Context context) {
        mLayoutInflater= LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.activity_recycle_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.recycle_name)
        TextView mRecycleName;
        @BindView(R.id.recycle_city)
        TextView mRecycleCity;
        @BindView(R.id.recycle_content)
        TextView mRecycleContent;
        @BindView(R.id.recycle_label)
        TextView mRecycleLabel;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
