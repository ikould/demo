package com.moris.user.mapper;

import com.moris.user.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

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
