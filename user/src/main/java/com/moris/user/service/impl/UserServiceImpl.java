package com.moris.user.service.impl;

import com.moris.user.entity.User;
import com.moris.user.mapper.UserMapper;
import com.moris.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    // 最大用户ID
    private static long maxUserId = -1;

    @Override
    public long insertUser(User user) {
        long userId = addOneUserId();
        user.setUserId(userId);
        System.out.println("==========================");
        System.out.println("userId = " + userId);
        System.out.println("==========================");
        boolean isSuccess = userMapper.insertUser(user);
        if (isSuccess) {
            return userId;
        }
        return -1;
    }

    @Override
    public boolean deleteUser(User user) {
        // 当前删除,仅将用户的删除字段置为1
        user.setIsDelete(1);
        return userMapper.updateUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User findUserById(long userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public User findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    @Override
    public User findUserByPhone(String phone, String phoneCode) {
        return userMapper.findUserByPhone(phone, phoneCode);
    }

    @Override
    public List<User> findAllUser(long offsetStart, int rowNums) {
        return userMapper.findAllUser(offsetStart, rowNums);
    }

    @Override
    public synchronized void initUser() {
        User user = userMapper.findMaxUserId();
        if (user == null)
            maxUserId = 0;
        else
            maxUserId = user.getUserId();
    }

    /**
     * 设置当前的最大用户ID
     */
    private synchronized long addOneUserId() {
        if (maxUserId == -1) {
            initUser();
        }
        maxUserId += 1;
        return maxUserId;
    }
}
