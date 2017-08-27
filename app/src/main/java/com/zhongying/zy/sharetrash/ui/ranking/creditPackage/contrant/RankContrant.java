package com.zhongying.zy.sharetrash.ui.ranking.creditPackage.contrant;

import com.zhongying.zy.sharetrash.entity.RankGson;

import java.util.List;

/**
 * Created by zy on 2017/8/27.
 */

public interface RankContrant {
    interface View{
        void returnData(List<RankGson.RanklistBean> datas);
    }

    interface OnLoadFirstDataListener{
        void  onSuccess(List<RankGson.RanklistBean> list);
        void  onFailure(String str,Throwable e);
    }

    interface Presenter  {
        void loadData(int type, int page);
    }

    interface Model {
        void loadData( int type, OnLoadFirstDataListener listener,int page);
    }
}
