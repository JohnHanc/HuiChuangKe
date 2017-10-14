package com.huida.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huida.R;
import com.huida.activity.DynamicActivity;
import com.huida.utils.IconBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2017/9/17.
 */

public class DyMsgFragment extends BaseFragment {

    private RecyclerView rv_dy_msg;
    private ArrayList<IconBean> list;

    @Override
    public View initView() {

        View view = View.inflate(mActivity, R.layout.fragment_dy_msg, null);
        rv_dy_msg = (RecyclerView) view.findViewById(R.id.rv_dy_msg);
        return view;
    }

    @Override
    public void initData() {
        rv_dy_msg.setLayoutManager(new LinearLayoutManager(mActivity));
        list = new ArrayList<>();
        list.add(new IconBean(1,"jjj"));
        DmRvAdapter adapter = new DmRvAdapter(R.layout.item_dymsg, list);
        rv_dy_msg.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(mActivity,position+"",600).show();
            }
        });

        /*FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fl_dymic,new DyStateFragment()).commit();*/

    }

 /* public   class DmRvAdapter extends RecyclerView.Adapter<DmRvAdapter.Holder>implements View.OnClickListener {

        private OnItemClickListener mOnItemClickListener=null;

        public  static interface OnItemClickListener {
            void onItemClick(View view , int position);
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_dymsg, parent, false);
            view.setOnClickListener(this);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.itemView.setTag(position);
            switch (position){
                case 0:
                    holder.iv_dymsg_icon.setBackgroundResource(R.mipmap.msg_mine);
                    holder.tv_dymsg_name.setText("@ 我的");
                    holder.tv_dymsg_name.setTextSize(18);

                    holder.tv_dymsg_chat.setVisibility(View.GONE);
                    holder.tv_dymsg_time.setVisibility(View.GONE);
                    holder.tv_dymsg_chatcount.setVisibility(View.GONE);
                    break;
                case 1:
                    holder.iv_dymsg_icon.setBackgroundResource(R.mipmap.msg_review);
                    holder.tv_dymsg_name.setText("评论");
                    holder.tv_dymsg_name.setTextSize(18);

                    holder.tv_dymsg_chat.setVisibility(View.GONE);
                    holder.tv_dymsg_time.setVisibility(View.GONE);
                    holder.tv_dymsg_chatcount.setVisibility(View.GONE);
                    break;
                case 2:
                    holder.iv_dymsg_icon.setBackgroundResource(R.mipmap.msg_zan);
                    holder.tv_dymsg_name.setText("赞");
                    holder.tv_dymsg_name.setTextSize(18);

                    holder.tv_dymsg_chat.setVisibility(View.GONE);
                    holder.tv_dymsg_time.setVisibility(View.GONE);
                    holder.tv_dymsg_chatcount.setVisibility(View.GONE);
                    break;
                default:

                    break;
            }

        }

        @Override
        public int getItemCount() {
            return 5;
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                //注意这里使用getTag方法获取position
                mOnItemClickListener.onItemClick(v,(int)v.getTag());
            }
        }
        public void setOnItemClickListener(OnItemClickListener listener) {
            this.mOnItemClickListener = listener;
        }

        class Holder extends RecyclerView.ViewHolder{

           private final TextView tv_dymsg_chatcount;
           private final TextView tv_dymsg_time;
           private final TextView tv_dymsg_chat;
           private final TextView tv_dymsg_name;
           private final ImageView iv_dymsg_icon;

           public Holder(View itemView) {
               super(itemView);
               iv_dymsg_icon = (ImageView) itemView.findViewById(R.id.iv_dymsg_icon);
               tv_dymsg_name = (TextView) itemView.findViewById(R.id.tv_dymsg_name);
               tv_dymsg_chat = (TextView) itemView.findViewById(R.id.tv_dymsg_chat);
               tv_dymsg_time = (TextView) itemView.findViewById(R.id.tv_dymsg_time);
               tv_dymsg_chatcount = (TextView) itemView.findViewById(R.id.tv_dymsg_chatcount);
           }
       }
    }*/
    class   DmRvAdapter    extends BaseQuickAdapter<IconBean,BaseViewHolder>{

         public DmRvAdapter(@LayoutRes int layoutResId, @Nullable List<IconBean> data) {
             super(layoutResId, data);
         }

         @Override
         protected void convert(BaseViewHolder helper, IconBean item) {
             helper.setText(R.id.tv_dymsg_name,item.getiName());
         }
    }
}
