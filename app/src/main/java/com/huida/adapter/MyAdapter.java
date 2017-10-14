package com.huida.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huida.R;
import com.huida.activity.DuttActivity;


/**
 * Created by liling on 2017/10/6.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private final DuttActivity mActivity;
    private final int[] icon;
    private final String[] iconName;
    private LayoutInflater inflater;


    public MyAdapter(DuttActivity duttActivity, int[] icon, String[] iconName) {
        this.icon= icon;
        this.mActivity=duttActivity;
        this.iconName=iconName;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.item_grid_icon, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.icon.setImageResource(icon[position]);
        holder.mTextView.setText(iconName[position]);

    }

    @Override
    public int getItemCount() {
        return icon.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView icon;
        private TextView  mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.img_icon);
            mTextView= (TextView) itemView.findViewById(R.id.txt_icon);


        }
    }
}
