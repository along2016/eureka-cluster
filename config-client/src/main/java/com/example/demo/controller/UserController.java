package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/6/26 0026.
 */
@RestController
@RefreshScope
public class UserController {

    @Value("${data.user.username}")
    private String name;

    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        return name;
    }
}
