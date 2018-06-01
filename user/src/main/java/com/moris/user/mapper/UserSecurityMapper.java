package com.moris.user.mapper;

import com.moris.user.entity.UserSecurity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSecurityMapper {

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
