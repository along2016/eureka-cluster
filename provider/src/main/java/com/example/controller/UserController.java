package com.example.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cloud.common.base.controller.BaseController;
import com.cloud.common.base.result.ResultMessage;
import com.example.entity.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResultMessage<List<User>> allList(User user) {
        return ResultMessage.success(userService.selectList(new EntityWrapper<>(user)));
    }

    /**
     * 新增用户信息表
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增用户信息表")
    public ResultMessage<User> add(@RequestBody User user) {
        boolean result = userService.insert(user);
        if (result)
            return ResultMessage.success(user);
        return ResultMessage.error();
        }

    /**
     * 删除用户信息表
     */
    @DeleteMapping(value = "/del")
    @ApiOperation("删除用户信息表")
    public ResultMessage<String> delById(@RequestParam("id") Long id) {
        boolean result = userService.deleteById(id);
        if (result)
            return ResultMessage.success();
        return ResultMessage.error();
        }

    /**
     * "批量删除用户信息表"
     */
//    @ResponseBody
//    @DeleteMapping(value = "/delete")
//    @ApiOperation("批量删除用户信息表")
//    public ResultMessage<Object> delByIds(String ids) {
//        return this.deleteBatchIds(ids, userService);
//    }

    /**
     * 修改用户信息表
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改用户信息表")
    public ResultMessage<String> update(@RequestBody User user) {
        boolean result = userService.updateById(user);
        if (result)
            return ResultMessage.success();
        return ResultMessage.error();
    }

    /**
     * 获取用户信息表
     */
    @GetMapping(value = "/get")
    @ApiOperation("查看用户信息表")
    public ResultMessage<User> get(@RequestParam("id") Long id) {
        return ResultMessage.success(userService.selectById(id));
    }

}

