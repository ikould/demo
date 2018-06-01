package com.moris.user.mapper;

import com.moris.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 插入用户
     */
    boolean insertUser(User user);

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
    User findUserByName(@Param("userName") String userName);

    /**
     * 通过phone查询用户
     */
    User findUserByPhone(@Param("phone") String phone, @Param("phoneCode") String phoneCode);

    /**
     * 分页查询用户
     *
     * @param offsetStart 开始的偏移量
     * @param rowNums     多少页数
     * @return 查询的所有结果
     */
    List<User> findAllUser(@Param("offsetStart") long offsetStart, @Param("rowNums") int rowNums);

    /**
     * 获取最大的用户Id
     */
    User findMaxUserId();
}
