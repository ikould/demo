package com.moris.user.service.impl;

import com.moris.user.entity.UserInfo;
import com.moris.user.mapper.UserInfoMapper;
import com.moris.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public boolean insertUserInfo(UserInfo userInfo) {
        return userInfoMapper.insertUserInfo(userInfo);
    }

    @Override
    public boolean deleteUserInfo(long userId) {
        return userInfoMapper.deleteUserInfo(userId);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public UserInfo findUserInfo(long userId) {
        return userInfoMapper.findUserInfo(userId);
    }
}
