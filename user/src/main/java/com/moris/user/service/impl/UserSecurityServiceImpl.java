package com.moris.user.service.impl;

import com.moris.user.entity.UserSecurity;
import com.moris.user.mapper.UserSecurityMapper;
import com.moris.user.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    UserSecurityMapper userSecurityMapper;

    @Override
    public boolean insertUserSecurity(UserSecurity userSecurity) {
        return userSecurityMapper.insertUserSecurity(userSecurity);
    }

    @Override
    public boolean updateUserSecurity(UserSecurity userSecurity) {
        return userSecurityMapper.updateUserSecurity(userSecurity);
    }

    @Override
    public List<UserSecurity> findUserSecurity(long userId) {
        return userSecurityMapper.findUserSecurity(userId);
    }
}
