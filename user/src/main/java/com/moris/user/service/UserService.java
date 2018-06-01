package com.moris.user.service;


import com.moris.user.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 插入用户
     *
     * @return UserId
     */
    long insertUser(User user);

    /**
     * 删除用户
     */
    boolean deleteUser(User user);

    /**
     * 更新用户信息
     */
    boolean updateUser(User user);

    /**
     * 通过userId查询用户
     */
    User findUserById(long userId);

    /**
     * 通过userName查询用户
     */
    User findUserByName(String userName);

    /**
     * 通过phone查询用户
     */
    User findUserByPhone(String phone,String phoneCode);

    /**
     * 分页查询用户
     *
     * @param offsetStart 开始的偏移量
     * @param rowNums     每一页多少量
     * @return 查询的所有结果
     */
    List<User> findAllUser(long offsetStart, int rowNums);

    /**
     * 初始化用户信息
     */
    void initUser();
}
