package com.huida.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.huida.R;

/**
 * Created by liling on 2017/10/14.
 */

public class CityRecycleAdapter extends RecyclerView.Adapter<CityRecycleAdapter.Hodler> {
    private static final String TAG ="city:" ;
    private final Activity mActivity;
    private final String[] cityString;

    public CityRecycleAdapter(Activity mActivity, String[] cityString) {
        this.mActivity=mActivity;
        this.cityString=cityString;
    }


    @Override
    public Hodler onCreateViewHolder(ViewGroup parent, int viewType) {
        Button view = (Button) LayoutInflater.from(mActivity).inflate(R.layout.xifen_rlview_item,parent,false);

        return new Hodler(view);
    }

    @Override
    public void onBindViewHolder(Hodler holder, int position) {
        Log.e(TAG, "onBindViewHolder: "+position );
        holder.bt_text.setText(cityString[position]);
    }


    @Override
    public int getItemCount() {
        return  cityString.length;
    }

    class Hodler extends RecyclerView.ViewHolder {

        private  Button bt_text;

        public Hodler(View itemView) {
            super(itemView);
            bt_text = (Button) itemView.findViewById(R.id.bt_text);
        }
    }
}
