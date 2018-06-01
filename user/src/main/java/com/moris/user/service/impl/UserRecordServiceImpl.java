package com.moris.user.service.impl;

import com.moris.user.entity.UserRecord;
import com.moris.user.mapper.UserRecordMapper;
import com.moris.user.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRecordServiceImpl implements UserRecordService {

    @Autowired
    UserRecordMapper userRecordMapper;

    @Override
    public boolean insertUserRecord(UserRecord userRecord) {
        return userRecordMapper.insertUserRecord(userRecord);
    }

    @Override
    public boolean deleteUserRecord(long userId, long minTime) {
        return userRecordMapper.deleteUserRecord(userId, minTime);
    }

    @Override
    public List<UserRecord> findUserRecord(long userId, long offsetStart, int rowNums) {
        return userRecordMapper.findUserRecord(userId, offsetStart, rowNums);
    }
}
