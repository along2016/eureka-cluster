package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 控制器
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-01
 */
@Validated
@RestController
@RequestMapping("/user")
@Api(tags = "用户信息表接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息表列表
     */
//    @GetMapping(value = "/list")
//    @ApiOperation("用户信息表列表")
//    public ResultMessage<Page<User>> list(User user) {
//        Page page = this.getPagination();
//        return ResultMessage.success(userService.selectPage(page,new EntityWrapper<>(user)));
//    }

    /**
    * 获取所有用户信息表列表
    */
    @GetMapping(value = "/allList")
    @ApiOperation("所有用户信息表列表")
    public Integer allList(User user) {
        return userService.insert(user);
    }


}

