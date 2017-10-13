package com.huida.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.huida.R;

/**
 * Created by Liu on 2017/9/17.
 */

public class DyStateFragment extends BaseFragment {

    private RecyclerView rv_dystate;
    private int[] drawables;
    private String[] strs;
    private RadioGroup rg_art;
    private RecyclerView rv_arts;
    private int rg_arts_checkId;

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_dy_state, null);
        rv_dystate = (RecyclerView) view.findViewById(R.id.rv_dystate);
        rg_art = (RadioGroup) view.findViewById(R.id.rg_dy_state_art);
        rv_arts = (RecyclerView) view.findViewById(R.id.rv_dys_arts);

        //recyclerview设置分割线
        rv_dystate.addItemDecoration(new DividerItemDecoration(mActivity, 0));//垂直分割线
        rv_dystate.addItemDecoration(new DividerItemDecoration(mActivity, 1));//水平分割线
        rv_arts.addItemDecoration(new DividerItemDecoration(mActivity, 1));//水平分割线

        return view;
    }

    @Override
    public void initData() {
        rv_dystate.setLayoutManager(new GridLayoutManager(mActivity, 3));
        rv_dystate.setAdapter(new DsRvAdapter());

        drawables = new int[]{R.mipmap.state_all, R.mipmap.state_tech, R.mipmap.state_managing,
                R.mipmap.state_marketing, R.mipmap.state_design, R.mipmap.state_product,
                R.mipmap.state_founder, R.mipmap.state_inverstor, R.mipmap.state_others};
        strs = new String[]{"全部", "技术合伙人", "运营合伙人",
                "营销合作人", "设计合伙人", "产品合伙人",
                "创始人", "投资人", "其他"};

        //选中的按钮ID
        rg_arts_checkId = rg_art.getCheckedRadioButtonId();
        rv_arts.setLayoutManager(new LinearLayoutManager(mActivity));
        rv_arts.setAdapter(new DsArtsRvadapter());


    //TODO ：网络获取文章


    }


    //recyclerview填充数据
    class DsRvAdapter extends RecyclerView.Adapter<DsRvAdapter.Holder>{

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_dystate_grid, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            holder.icon.setBackgroundResource(drawables[position]);
            holder.title.setText(strs[position]);
            //网络获取动态条数
        }

        @Override
        public int getItemCount() {
            return strs.length;
        }

        class Holder extends RecyclerView.ViewHolder{

            private final ImageView icon;
            private final TextView title;
            private final TextView all;
            private final TextView today;

            public Holder(View itemView) {
                super(itemView);
                icon = (ImageView) itemView.findViewById(R.id.iv_dys_gridicon);
                title = (TextView) itemView.findViewById(R.id.tv_dys_gridtitle);
                all = (TextView) itemView.findViewById(R.id.tv_dys_gridall);
                today = (TextView) itemView.findViewById(R.id.tv_dys_gridtoday);
            }
        }

    }

    //文章列表适配
    class DsArtsRvadapter extends RecyclerView.Adapter<DsArtsRvadapter.Holder>{
        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_dystate_arts, parent, false);
            return new Holder(view);
        }


        @Override
        public void onBindViewHolder(Holder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 6;
        }

        class Holder extends RecyclerView.ViewHolder{

            private final ImageView cv_icon;
            private final TextView tv_name;
            private final TextView tv_time;
            private final TextView tv_title;
            private final ImageView iv_icon;
            private final ImageView iv_img;

            public Holder(View itemView) {
                super(itemView);
                cv_icon = (ImageView) itemView.findViewById(R.id.iv_dys_icon);
                tv_name = (TextView) itemView.findViewById(R.id.tv_dys_name);
                tv_time = (TextView) itemView.findViewById(R.id.tv_dys_time);
                tv_title = (TextView) itemView.findViewById(R.id.tv_dys_title);
                iv_icon = (ImageView) itemView.findViewById(R.id.iv_dys_icon);
                iv_img = (ImageView) itemView.findViewById(R.id.iv_dys_img);
            }
        }
    }

}
