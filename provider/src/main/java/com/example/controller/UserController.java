package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.result.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import com.example.service.UserService;
import com.example.entity.User;

/**
 * <p>
 * 用户信息 控制器
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-10
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("用户信息列表")
    public ResultMessage<Page<User>> list(User user) {
        Page page = new Page(1,5);
        return ResultMessage.success(userService.page(page, new QueryWrapper<>(user)));
    }

    /**
    * 获取所有用户信息列表
    */
    @GetMapping(value = "/allList")
    @ApiOperation("所有用户信息列表")
    public ResultMessage<List<User>> allList() {
        return ResultMessage.success(userService.list());
    }

    /**
     * 新增用户信息
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增用户信息")
    public ResultMessage<User> add(@RequestBody User user) {
        boolean result = userService.save(user);
        if (result){
            return ResultMessage.success(user);
        }
        return ResultMessage.error();
    }

    /**
     * 删除用户信息
     */
    @DeleteMapping(value = "/del")
    @ApiOperation("删除用户信息")
    public ResultMessage<String> delById(@RequestParam("id") Long id) {
        boolean result = userService.removeById(id);
        if (result){
            return ResultMessage.success();
        }
        return ResultMessage.error();
    }

    /**
     * "批量删除用户信息"
     */
    @ResponseBody
    @DeleteMapping(value = "/delete")
    @ApiOperation("批量删除用户信息")
    public ResultMessage<Object> delByIds(String ids) {
        List idList = Arrays.asList(ids.split(","));
        return userService.removeByIds(idList) ? ResultMessage.success(ResultMessage.OK, "删除成功") :
        ResultMessage.error(ResultMessage.FAIL, "删除失败");
    }

    /**
     * 修改用户信息
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改用户信息")
    public ResultMessage<String> update(@RequestBody User user) {
        boolean result = userService.updateById(user);
        if (result){
            return ResultMessage.success();
        }
        return ResultMessage.error();
    }

    /**
     * 获取用户信息
     */
    @GetMapping(value = "/get")
    @ApiOperation("查看用户信息")
    public ResultMessage<User> get(@RequestParam("id") Long id) {
        return ResultMessage.success(userService.getById(id));
    }

}

