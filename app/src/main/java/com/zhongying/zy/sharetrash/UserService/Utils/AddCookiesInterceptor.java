package com.zhongying.zy.sharetrash.UserService.Utils;

import com.orhanobut.hawk.Hawk;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by DELL on 2017/8/23.
 */

public class AddCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        if(Hawk.contains("sessionId")){
            builder.addHeader("Cookie", "sessionId="+Hawk.get("sessionId").toString());
        }
        return chain.proceed(builder.build());
    }
}
