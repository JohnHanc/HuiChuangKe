package com.huida.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.huida.R;
import com.huida.view.DividerItemDecoration;

import java.util.List;

/**
 * Created by Han on 2017/9/27.
 */

public class FindPersonViewPagerAdapter extends PagerAdapter {
    private List<String> mDataList;
    private Context mContext;
    public FindPersonViewPagerAdapter(List<String> dataList, Context context) {
        mContext = context;
        mDataList = dataList;
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = View.inflate(mContext, R.layout.activity_recyclerview, null);
        RecyclerView rv_content = (RecyclerView) view.findViewById(R.id.rv_content);
        rv_content.setAdapter(new FindPersonRecyclerAdapter(mContext));
        //为recyclerview设置布局管理器
        rv_content.setLayoutManager(new LinearLayoutManager(mContext));

        //为RecyclerView设置分割线(可以对DivederItemDecoration进行修改，自定义)
        rv_content.addItemDecoration(new DividerItemDecoration(mContext,DividerItemDecoration.HORIZONTAL_LIST,R.mipmap.horizontalline));
//        动画
        rv_content.setItemAnimator(new DefaultItemAnimator());


        rv_content.setAdapter(new FindPersonRecyclerAdapter(mContext));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getItemPosition(Object object) {
        TextView textView = (TextView) object;
        String text = textView.getText().toString();
        int index = mDataList.indexOf(text);
        if (index >= 0) {
            return index;
        }
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position);
    }
}
