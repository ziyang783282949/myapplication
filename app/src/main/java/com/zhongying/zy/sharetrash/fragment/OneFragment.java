package com.zhongying.zy.sharetrash.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;
import com.zhongying.zy.sharetrash.R;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.activity.Credit;

/**
 * Created by zy on 2017/7/10.
 */

public class OneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one,container,false);
        return view;
    }
    public static OneFragment newInstance(){
        OneFragment fragment=new OneFragment();
        return fragment;
    }
}
