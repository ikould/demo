package com.moris.material.mapper;

import com.moris.material.entity.Admin;
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
