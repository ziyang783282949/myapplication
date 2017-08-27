package com.zhongying.zy.sharetrash.ui.ranking.creditPackage.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.zhongying.zy.sharetrash.R;
import com.zhongying.zy.sharetrash.adapter.TestRecyclerViewAdapter;
import com.zhongying.zy.sharetrash.entity.RankGson;
import com.zhongying.zy.sharetrash.ui.base.BaseFragent;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.adapter.CreditAdapter;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.contrant.RankContrant;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.presenter.CreditPresent;
import com.zhongying.zy.sharetrash.util.PixUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class RecyclerViewFragment extends BaseFragent implements RankContrant.View{
    private CreditAdapter adapter;
    private RankContrant.Presenter mPresenter;

    private boolean isViewPrepared; // 标识fragment视图已经初始化完毕
    private boolean hasFetchData; // 标识已经触发过懒加载数据
    private int type;
    public static RecyclerViewFragment newInstance(){
        RecyclerViewFragment fragment=new RecyclerViewFragment();
        return fragment;
    }

    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;
    private int pageIndex = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit, container, false);
        ButterKnife.bind(this, view);

        mPresenter=new CreditPresent(this,getContext());
        recyclerView.setAdapter(adapter = new CreditAdapter(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //添加边框
        recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        //更多加载
       /* adapter.setMore(R.layout.view_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                mPresenter.loadData(type,pageIndex);
                pageIndex=pageIndex+1;
            }

            @Override
            public void onMoreClick() {

            }
        });*/
        //写刷新事件
        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        pageIndex = 0;
                        mPresenter.loadData(type,pageIndex);
                    }
                }, 1000);
            }
        });
        isViewPrepared = true;

        return view;
    }

    @Override
    public void returnData(List<RankGson.RanklistBean> datas) {
        adapter.addAll(datas);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void lazyFetchDataIfPrepared() {
        Log.e("data",type+""+isViewPrepared+"&&&"+hasFetchData);
        if (isViewPrepared && getUserVisibleHint() && !hasFetchData) {
            lazyFetchData();
            hasFetchData = true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //视图销毁 数据设置为空
        hasFetchData=false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyFetchDataIfPrepared();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hasFetchData = false;
        isViewPrepared = false;
    }

    protected void lazyFetchData() {
        mPresenter.loadData(type,pageIndex);
        pageIndex=pageIndex+1;
    }


    /*private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        final List<Object> items = new ArrayList<>();

        for (int i = 0; i < ITEM_COUNT; ++i) {
            items.add(new Object());
        }


        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new TestRecyclerViewAdapter(items));
    }*/
}
