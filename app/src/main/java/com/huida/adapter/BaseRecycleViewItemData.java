package com.huida.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.huida.R;
import com.huida.activity.DuttActivity;
import com.huida.pager.ContentDataPager;

/**
 * Created by liling on 2017/10/13.
 */

public class BaseRecycleViewItemData extends RecyclerView.Adapter {
    private final Context context;

    public BaseRecycleViewItemData(Context duttActivity) {
        this.context=duttActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.findproject_rlview_item, parent,false);

        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 5;
    }
    class Holder extends BaseViewHolder {

        private final TextView item_title;
        private final TextView item_brief;

        public Holder(View view) {
            super(view);
            item_title = (TextView) itemView.findViewById(R.id.rl_item_title);
            item_brief = (TextView) itemView.findViewById(R.id.rl_item_brief);
        }
    }
}
