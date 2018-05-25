package com.moris.user.mapper;

import com.moris.user.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    /**
     * 查询Admin
     *
     * @return admin
     */
    Admin queryAdmin(int id);
}
