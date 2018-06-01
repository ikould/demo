package com.ikould.express.network;

import com.adnonstop.frame.net.RetrofitHelper;

import retrofit2.Retrofit;

/**
 * Retrofit帮助类
 * <p>
 * Created by ikould on 2017/6/2.
 */

public class UserNetHelper {

    /**
     * URL基础地址
     */
    public static final String BASE_URL = "";

    /**
     * URL基础测试地址
     */
    public static final String TEST_BASE_URL = "http://192.168.4.79:8801/user/";

    private static Retrofit retrofit;

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (UserNetHelper.class) {
                if (retrofit == null) {
                    retrofit = RetrofitHelper.createRetrofit(TEST_BASE_URL, null);
                }

            }
        }
        return retrofit;
    }

    public static UserNetService getRetrofitService() {
        return getRetrofit().create(UserNetService.class);
    }
}
