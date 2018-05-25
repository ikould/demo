package com.moris.material.service;


public interface AdminService {

    /**
     * 查询Admin
     *
     * @return admin
     */
    boolean queryAdmin(String name, String password);
}
