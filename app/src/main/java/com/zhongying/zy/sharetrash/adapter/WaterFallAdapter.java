package com.zhongying.zy.sharetrash.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhongying.zy.sharetrash.R;
import com.zhongying.zy.sharetrash.entity.ImageBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zy on 2017/10/15.
 */

public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.ViewHolder> {

    private Context mContext;
    private List<ImageBean> mList = new ArrayList<>();
    private List<Integer> mHeights;

    public WaterFallAdapter(Context context){
        this.mContext = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_image_text, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        holder.itemView.setLayoutParams(layoutParams);

        ImageBean bean = mList.get(position);
        Glide.with(mContext)
                .load(bean.getIcon())
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(holder.mImageView);
        holder.textView.setText(bean.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imageview)
        ImageView mImageView;

        @BindView(R.id.text_view)
        TextView textView;

        public ViewHolder(View view){
            //需要设置super
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public List<ImageBean> getList() {
        return mList;
    }


}

