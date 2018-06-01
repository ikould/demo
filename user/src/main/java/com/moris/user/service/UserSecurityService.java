package com.moris.user.service;

import com.moris.user.entity.UserSecurity;

import java.util.List;

public interface UserSecurityService {

    /**
     * 插入密保问题
     */
    boolean insertUserSecurity(UserSecurity userSecurity);

    /**
     * 修改密保问题
     */
    boolean updateUserSecurity(UserSecurity userSecurity);

    /**
     * 查找当前用户下的所有密保问题
     */
    List<UserSecurity> findUserSecurity(long userId);
}
