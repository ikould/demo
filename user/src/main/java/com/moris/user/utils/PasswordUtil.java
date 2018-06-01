package com.moris.user.utils;

public class PasswordUtil {

    /**
     * 验证密码是否满足要求
     */
    public static boolean isUsefulPassword(String password) {
        boolean isUseful = false;
        if (!TextUtils.isEmpty(password) && password.length() >= 8)
            isUseful = true;
        return isUseful;
    }
}
