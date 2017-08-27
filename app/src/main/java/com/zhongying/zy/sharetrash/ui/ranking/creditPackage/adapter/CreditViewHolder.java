package com.zhongying.zy.sharetrash.ui.ranking.creditPackage.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zhongying.zy.sharetrash.R;
import com.zhongying.zy.sharetrash.entity.RankGson;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.contrant.RankContrant;
import com.zhongying.zy.sharetrash.util.PictureUtil;

/**
 * Created by zy on 2017/8/27.
 */

public class CreditViewHolder extends BaseViewHolder<RankGson.RanklistBean> {
    private TextView id;
    private ImageView icon;
    private TextView name;
    private TextView point;

    public CreditViewHolder(ViewGroup parent){
        super(parent, R.layout.credit_recycler_item);
        id= $(R.id.id);
        icon=$(R.id.icon);
        name=$(R.id.name);
        point=$(R.id.point);
    }

    @Override
    public void setData(RankGson.RanklistBean data) {
        id.setText(data.getId());
        name.setText(data.getName());
        point.setText(data.getPoint());
        PictureUtil.showImage(icon,getContext(),data.getIcon());
    }
}
