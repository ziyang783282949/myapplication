package com.zhongying.zy.sharetrash.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.orhanobut.hawk.Hawk;
import com.zhongying.zy.sharetrash.R;
import com.zhongying.zy.sharetrash.adapter.WaterFallAdapter;
import com.zhongying.zy.sharetrash.entity.ImageBean;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.activity.Credit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zy on 2017/7/10.
 */

public class OneFragment extends Fragment {
    private ImageView ttttt;
    private RollPagerView rollPagerView;
    private RecyclerView mRecyclerView;
    private WaterFallAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        ttttt= (ImageView) view.findViewById(R.id.tttttttt);
        bindView(view);
        return view;
    }
    public static OneFragment newInstance(){
        OneFragment fragment=new OneFragment();
        return fragment;
    }
    public void bindView(View view){
        rollPagerView= (RollPagerView) view.findViewById(R.id.rollviewpager);
        rollPagerView.setPlayDelay(2000);
        rollPagerView.setAdapter(new TestNormalAdapter());
        mRecyclerView= (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAdapter = new WaterFallAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        initData();

    }
    public void initData(){
        //获取图片资源数组
        TypedArray images = getResources().obtainTypedArray(R.array.pictures);


        String[] pictures = getResources().getStringArray(R.array.pictures);
        String[] titles = getResources().getStringArray(R.array.items);
        List<ImageBean> list = new ArrayList<>();
        for(int i=0;i<pictures.length;i++){
            ImageBean bean = new ImageBean();
            bean.setIcon(images.getResourceId(i,-1));
            bean.setTitle(titles[i]);
            list.add(bean);
        }
        //ttttt.setImageResource(images.getResourceId(0,-1));
        mAdapter.getList().addAll(list);
        mAdapter.notifyDataSetChanged();
    }
    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.env1,
                R.drawable.env2,
                R.drawable.env3,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
