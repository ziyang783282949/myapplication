package com.zhongying.zy.sharetrash.ReferenceRetrofit;


import com.zhongying.zy.sharetrash.UserService.Utils.AddCookiesInterceptor;
import com.zhongying.zy.sharetrash.UserService.Utils.ReceivedCookiesInterceptor;
import com.zhongying.zy.sharetrash.constant.AppConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFactory {
    //private static String baseUrl = "http://fchieg.natappfree.cc/porkerticket/";
    private static String baseUrl = AppConfig.BASE_URL;
    private RetroFactory() {
    }

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new AddCookiesInterceptor())
            .addInterceptor(new ReceivedCookiesInterceptor())
            .connectTimeout(300000, TimeUnit.SECONDS)
            .readTimeout(300000, TimeUnit.SECONDS)
            .build();

    private static RetrofitService retrofitService = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(RetrofitService.class);

    public static RetrofitService getInstance() {
        return retrofitService;
    }

}
