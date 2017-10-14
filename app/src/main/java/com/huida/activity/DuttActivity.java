package com.huida.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huida.R;
import com.huida.adapter.BaseRecycleViewItemData;
import com.huida.adapter.FindPersonRecyclerAdapter;
import com.huida.adapter.MyAdapter;
import com.huida.view.DividerItemDecoration;

import static com.huida.view.DividerItemDecoration.BOTH_SET;
import static com.huida.view.DividerItemDecoration.HORIZONTAL_LIST;


/**
 * Created by liling on 2017/9/24.
 */

public  class DuttActivity extends BaseActivity {

    private static final String TAG = "TEst";
    private RecyclerView rl_photo;
 //   private ArrayList<IconBean> icons;
    private BaseAdapter myAdapter=null;
    private ViewPager vp_images;

        private int[] icon = { R.mipmap.icon_zr_1, R.mipmap.icon_qg_2,
            R.mipmap.icon_zs_3,R.mipmap.icon_tz_4,R.mipmap.icon_xq_5,R.mipmap.icon_jm_6};
    private String[] iconName = { "转让", "求购", "招商", "投资", "需求","加盟 "};
    /*private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                //加载更多

            }else{
                //轮播图切换下一页
                vp_images.setCurrentItem((vp_images.getCurrentItem()+1)%6);

                //再次发送消息（循环）
                handler.sendEmptyMessageDelayed(0,3000);
            }


        }
    };*/
    private RecyclerView rl_tools;


    @Override
    protected int getLayoutId() {
        Log.e("liling", "getLayoutId: "+"layout" );
        return R.layout.butt_layout;
    }

    @Override
    public void initView() {
        rl_photo = (RecyclerView) findViewById(R.id.rl_photo);
        vp_images = (ViewPager) findViewById(R.id.vp_images);
        rl_tools = (RecyclerView) findViewById(R.id.rl_tools);

    }

    @Override
    protected void initData() {
        Log.e("pager", "initData: "+"ceshi");
        initPager();
        //grid  九宫格数据
        initGridData();
        //设置九宫格的各个数据
        initGridItemData();


    }

    private void initGridItemData() {
        rl_tools.setLayoutManager(new LinearLayoutManager(this));
        rl_tools.setAdapter(new BaseRecycleViewItemData(this) );
        rl_tools.addItemDecoration(new DividerItemDecoration(this,HORIZONTAL_LIST));
    }

    private void initGridData() {
        rl_photo.setLayoutManager(new GridLayoutManager(this,3));
        rl_photo.setAdapter(new MyAdapter(this,icon,iconName));
        rl_photo.addItemDecoration(new DividerItemDecoration(this, BOTH_SET));
    }

    private void initPager() {
        PagerImagesAdapter pagerImagesAdapter = new PagerImagesAdapter();
        vp_images.setAdapter(pagerImagesAdapter);
    }

    @Override
    protected void initLisitenr() {

    }
    public class PagerImagesAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.e("adapter", "instantiateItem: "+position);
            ImageView iv = new ImageView(DuttActivity.this);
            iv.setImageResource(R.mipmap.pic_wanda);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            container.addView(iv);
            return iv;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }


    }
}
