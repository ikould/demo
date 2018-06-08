package com.ikould.express.user.task;

import android.util.Log;

import com.adnonstop.frame.util.EncryptionUtil;
import com.ikould.express.user.network.UserNetHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import rx.schedulers.Schedulers;

/**
 * describe
 * Created by ikould on 2018/5/30.
 */
public class UserTask {


    // ====== 单例 ======

    private volatile static UserTask instance;

    public static UserTask getInstance() {
        if (instance == null) {
            synchronized (UserTask.class) {
                if (instance == null) {
                    instance = new UserTask();
                }
            }
        }
        return instance;
    }

    private UserTask() {
    }

    // ====== 操作 ======

    /**
     * {
     * "param": {
     * "nickname": "liudong",
     * "phone": "1234",
     * "userPassword":"12345678"
     * "phoneCode": "+86"
     * },
     * "osType": "android",
     * "imei": "G688535GHISLF"
     * }
     */
    public void register() {
        try {
            // 参数
            JSONObject paramObject = new JSONObject();
            paramObject.put("nickname", "liudong2");
            paramObject.put("phone", "12345678");
            paramObject.put("userPassword", "123456789");
            paramObject.put("phoneCode", "+86");
            // 結果
            HashMap<String, String> maps = new HashMap<>();
            maps.put("param", EncryptionUtil.encryptBase64(paramObject.toString()));
            // 其它
            maps.put("osType", "android");
            maps.put("imei", "SDJLIJILSJ243234FSOIJFOI");
            UserNetHelper
                    .getRetrofitService()
                    .userRegister(maps)
                    .subscribeOn(Schedulers.io())
                    .subscribe(s -> {
                        try {
                            Log.d("UserTask", "register: s = " + new JSONObject(s).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }, throwable -> {
                        Log.e("UserTask", "register: e = " + throwable);
                    });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        try {
            // 参数
            JSONObject paramObject = new JSONObject();
            paramObject.put("userPassword", "123456789");
            paramObject.put("phone", "12345678");
            paramObject.put("phoneCode", "+86");
            // 結果
            HashMap<String, String> maps = new HashMap<>();
            maps.put("param", EncryptionUtil.encryptBase64(paramObject.toString()));
            // 其它
            maps.put("osType", "android");
            maps.put("imei", "SDJLIJILSJ243234FSOIJFOI");
            UserNetHelper
                    .getRetrofitService()
                    .userLogin(maps)
                    .subscribeOn(Schedulers.io())
                    .subscribe(s -> {
                        try {
                            Log.d("UserTask", "login: s = " + new JSONObject(s).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }, throwable -> {
                        Log.e("UserTask", "login: e = " + throwable);
                    });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        try {
            // 参数
            JSONObject paramObject = new JSONObject();
            paramObject.put("nickname", "liudong");
            paramObject.put("phone", "1234");
            paramObject.put("phoneCode", "+86");
            // 結果
            HashMap<String, String> maps = new HashMap<>();
            maps.put("param", EncryptionUtil.encryptBase64(paramObject.toString()));
            // 其它
            maps.put("osType", "android");
            maps.put("imei", "SDJLIJILSJ243234FSOIJFOI");
            UserNetHelper
                    .getRetrofitService()
                    .userRegister(maps)
                    .subscribeOn(Schedulers.io())
                    .subscribe(s -> {
                        try {
                            Log.d("UserTask", "register: s = " + new JSONObject(s).toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }, throwable -> {
                        Log.e("UserTask", "register: e = " + throwable);
                    });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
