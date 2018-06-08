package com.moris.material.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    private String userServicePath;

    @RequestMapping(value = "/get/{username}/{password}", method = RequestMethod.GET, produces = "application/json")
    public String getMaterial(@PathVariable String username, @PathVariable String password) {
        return this.restTemplate.getForObject(this.userServicePath + "user/admin/" + username + "/" + password, String.class);
    }
}
