package com.moris.user.controller;

import com.moris.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     */
    @RequestMapping(value = "/get/{username}/{password}", method = RequestMethod.GET, produces = "application/json")
    public boolean getAdmin(@PathVariable String username, @PathVariable String password) {
        return adminService.queryAdmin(username, password);
    }
}
