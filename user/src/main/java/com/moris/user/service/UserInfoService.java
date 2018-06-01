package com.moris.user.service;

import com.moris.user.entity.UserInfo;

public interface UserInfoService {

    /**
     * 插入
     */
    boolean insertUserInfo(UserInfo userInfo);

    /**
     * 删除
     */
    boolean deleteUserInfo(long userId);

    /**
     * 更新
     */
    boolean updateUserInfo(UserInfo userInfo);

    /**
     * 查找
     */
    UserInfo findUserInfo(long userId);
}
