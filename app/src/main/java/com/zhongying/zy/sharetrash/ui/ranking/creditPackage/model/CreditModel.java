package com.zhongying.zy.sharetrash.ui.ranking.creditPackage.model;

import android.app.ProgressDialog;

import com.zhongying.zy.sharetrash.ReferenceRetrofit.BaseEntity;
import com.zhongying.zy.sharetrash.ReferenceRetrofit.BaseObserver;
import com.zhongying.zy.sharetrash.ReferenceRetrofit.RetroFactory;
import com.zhongying.zy.sharetrash.ReferenceRetrofit.RetrofitService;
import com.zhongying.zy.sharetrash.constant.AppConfig;
import com.zhongying.zy.sharetrash.entity.RankGson;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.contrant.RankContrant;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

/**
 * Created by zy on 2017/8/27.
 */

public class CreditModel implements RankContrant.Model{
    private ProgressDialog pd;
    @Override
    public void loadData(int type, final RankContrant.OnLoadFirstDataListener listener, int page) {
        RetrofitService apiService= RetroFactory.getInstance();
       apiService.getCredit("getGredit")
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .map(new Function<BaseEntity<RankGson>, List<RankGson.RanklistBean>>() {
                   @Override
                   public List<RankGson.RanklistBean> apply(BaseEntity<RankGson> rankGsonBaseEntity) throws Exception {
                       List<RankGson.RanklistBean> newsList = new ArrayList<RankGson.RanklistBean>();

                       newsList=rankGsonBaseEntity.getData().getNewslist();
                       for(int i=0;i<newsList.size();i++){
                           String userIcon=newsList.get(i).getIcon().substring(newsList.get(i).getIcon().indexOf("\\")+1);
                           userIcon= AppConfig.Picture+userIcon;
                           userIcon=userIcon.replace("\\","/");
                           newsList.get(i).setIcon(userIcon);
                       }
                       return newsList; // 返回类型

                   }
               })
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<List<RankGson.RanklistBean>>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(List<RankGson.RanklistBean> value) {
                        listener.onSuccess(value);
                   }

                   @Override
                   public void onError(Throwable e) {
                       listener.onFailure("请求失败",e);
                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }
}
