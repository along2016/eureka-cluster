package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2020/6/29 0029.
 */
@FeignClient(value = "provider")
public interface UserInfoService {

    @GetMapping(value = "/getUser")
    String getUserInfo();
}
