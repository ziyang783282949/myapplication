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
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;
import com.zhongying.zy.sharetrash.R;
import com.zhongying.zy.sharetrash.ReferenceRetrofit.SharedPreferencesUtils;
import com.zhongying.zy.sharetrash.activity.UserLogin;
import com.zhongying.zy.sharetrash.ui.ranking.creditPackage.activity.Credit;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zy on 2017/7/10.
 */

public class ThreeFragment extends Fragment {
    private ImageView first;
    private TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_three,container,false);
        first= (ImageView) view.findViewById(R.id.first);
        tv= (TextView) view.findViewById(R.id.textView);
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Credit.class));
                if(Hawk.contains("sessionId")) {
                    String name=Hawk.get("sessionId").toString();
                    //String userinfo= (String) SharedPreferencesUtils.getParam(getContext(),"String","");
                    //Toast.makeText(getActivity(), name, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getActivity(), Credit.class));
                }
            }
        });
        return view;
    }
    public static ThreeFragment newInstance(){
        ThreeFragment fragment=new ThreeFragment();
        return fragment;
    }
}
