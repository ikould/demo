package com.moris.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @GetMapping("/admin/{adminName}/{adminPassword}")
    public String checkAdmin(@PathVariable String adminName, @PathVariable String adminPassword) {
        return this.restTemplate.getForObject(this.userServicePath + "admin/get/" + adminName + "/" + adminPassword, String.class);
    }
}
