package com.moris.user.service;

import com.moris.user.entity.UserRecord;

import java.util.List;

public interface UserRecordService {

    /**
     * 插入用户记录
     */
    boolean insertUserRecord(UserRecord userRecord);

    /**
     * 删除用户记录
     */
    boolean deleteUserRecord(long userId, long minTime);

    /**
     * 查看用户记录
     */
    List<UserRecord> findUserRecord(long userId, long offsetStart, int rowNums);
}
