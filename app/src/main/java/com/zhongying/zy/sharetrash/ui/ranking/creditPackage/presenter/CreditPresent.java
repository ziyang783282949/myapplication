package com.zhongying.zy.sharetrash.ui.ranking.creditPackage.presenter;

import android.content.Context;
import android.widget.Toast;

import com.zhongying.zy.sharetrash.entity.RankGson;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.contrant.RankContrant;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.model.CreditModel;

import java.util.List;

/**
 * Created by zy on 2017/8/27.
 */

public class CreditPresent implements RankContrant.Presenter,RankContrant.OnLoadFirstDataListener{
    private RankContrant.View view;
    private RankContrant.Model model;
    private Context context;

    public CreditPresent(RankContrant.View view,Context context){
        this.view=view;
        this.model=new CreditModel();
        this.context=context;
    }

    @Override
    public void onSuccess(List<RankGson.RanklistBean> list) {
        view.returnData(list);
    }

    @Override
    public void onFailure(String str, Throwable e) {
        Toast.makeText(this.context,"访问失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadData(int type, int page) {
        model.loadData(type,this,page);
    }
}
