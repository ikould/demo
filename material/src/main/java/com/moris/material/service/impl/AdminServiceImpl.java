package com.moris.material.service.impl;

import com.moris.material.entity.Admin;
import com.moris.material.mapper.AdminMapper;
import com.moris.material.service.AdminService;
import com.moris.material.utils.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Transactional // 加入事务
    @Override
    public boolean queryAdmin(String name, String password) {
        Admin admin = adminMapper.queryAdmin(1);
        System.out.println("=========================");
        System.out.println("name = " + name + " password = " + password);
        System.out.println("admin = " + admin);
        System.out.println("=========================");

        if (admin != null && TextUtils.equals(admin.getAdminPassword(), password))
            return true;
        return false;
    }
}
