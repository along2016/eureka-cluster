package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/6/29 0029.
 */
@RestController
public class UserController {

    @GetMapping(value = "/getUser")
    public String getUser(){
        return "aliang";
    }

}
