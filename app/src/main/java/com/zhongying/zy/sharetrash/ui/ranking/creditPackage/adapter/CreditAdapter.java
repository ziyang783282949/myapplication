package com.zhongying.zy.sharetrash.ui.ranking.creditPackage.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zhongying.zy.sharetrash.entity.RankGson;

/**
 * Created by zy on 2017/8/27.
 */

public class CreditAdapter extends RecyclerArrayAdapter<RankGson.RanklistBean> {
    public CreditAdapter(Context context){
        super(context);
    }
    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new CreditViewHolder(parent);
    }
}
