package com.moris.user.controller.task;

import com.moris.user.entity.User;
import com.moris.user.entity.UserInfo;
import com.moris.user.entity.UserRecord;
import com.moris.user.service.UserService;
import com.moris.user.utils.TextUtils;
import org.json.JSONObject;

import java.util.UUID;

public class UserTask {

    /**
     * 用户记录
     */
    public static UserRecord userRecord(long userId, String osType, String imei, String msg) {
        UserRecord record = new UserRecord();
        record.setImei(imei);
        record.setOsType(osType);
        record.setMsg(msg);
        record.setTime(System.currentTimeMillis());
        record.setUserId(userId);
        return record;
    }

    /**
     * 將UserInfo转换为JSON形式
     */
    public static JSONObject getUserInfoByJson(UserInfo userInfo, User user) {
        JSONObject userJson = new JSONObject();
        userJson.put("userId", userInfo.getUserId());
        userJson.put("nickname", userInfo.getNickname());
        userJson.put("token", user.getAccessToken());
        userJson.put("iconPath", userInfo.getIconPath());
        userJson.put("sex", userInfo.getSex());
        userJson.put("phone", user.getPhone());
        userJson.put("phoneCode", user.getPhoneCode());
        userJson.put("signature", userInfo.getSignature());
        userJson.put("birthYear", userInfo.getBirthYear());
        userJson.put("birthMonth", userInfo.getBirthMonth());
        userJson.put("birthDay", userInfo.getBirthDay());
        userJson.put("locationId", userInfo.getLocationId());
        userJson.put("isSecurity", user.getIsSecurity());
        return userJson;
    }

    /**
     * 检验Token是否正确
     */
    public static boolean checkToken(long userId, UserService userService, String nowToken) {
        User user = userService.findUserById(userId);
        return TextUtils.equals(nowToken, user.getAccessToken());
    }

    /**
     * 生成token
     */
    public static String genAccessToken() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
