package com.moris.user.mapper;

import com.moris.user.entity.UserRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRecordMapper {

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
