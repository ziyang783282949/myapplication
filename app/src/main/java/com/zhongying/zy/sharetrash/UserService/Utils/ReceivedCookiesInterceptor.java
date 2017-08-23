package com.zhongying.zy.sharetrash.UserService.Utils;

import com.orhanobut.hawk.Hawk;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by DELL on 2017/8/23.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if (!originalResponse.headers("Set-Cookie").isEmpty()) {

            for (String header : originalResponse.headers("Set-Cookie")) {
                String[] keys=header.split("=");
                if (keys[0].equals("sessionId")) {
                    Hawk.put("sessionId",keys[1]);
                }
            }
        }

        return originalResponse;
    }
}
