package com.ikould.express.user.network;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 网络接口
 * <p>
 * Created by ikould on 2017/6/2.
 */

public interface UserNetService {

    /**
     * 登录接口URL
     */
    String LOGIN_URL = "login";

    /**
     * 注册接口
     */
    String REGISTER_URL = "register";

    /**
     * 修改用户信息
     */
    String UPDATE_USER_INFO = "update";

    // 用户登录
    @FormUrlEncoded
    @POST(LOGIN_URL)
    Observable<String> userLogin(@FieldMap Map<String, String> maps);

    // 用户注册
    @FormUrlEncoded
    @POST(REGISTER_URL)
    Observable<String> userRegister(@FieldMap Map<String, String> maps);

    // 修改用户信息
    @FormUrlEncoded
    @POST(UPDATE_USER_INFO)
    Observable<String> updateUserInfo(@FieldMap Map<String, String> maps);
}
