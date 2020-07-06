package com.example.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.f00lish.xcloud.common.base.result.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import com.example.service.CompanyService;
import com.example.entity.Company;

/**
 * <p>
 * 公司信息 控制器
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-06
 */
@Validated
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 获取公司信息列表
     */
    @GetMapping(value = "/list")
    @ApiOperation("公司信息列表")
    public ResultMessage<Page<Company>> list(Company company) {
        Page page = this.getPagination();
        return ResultMessage.success(companyService.selectPage(page,new EntityWrapper<>(company)));
    }

    /**
    * 获取所有公司信息列表
    */
    @GetMapping(value = "/allList")
    @ApiOperation("所有公司信息列表")
    public ResultMessage<List<Company>> allList(Company company) {
        return ResultMessage.success(companyService.selectList(new EntityWrapper<>(company)));
    }

    /**
     * 新增公司信息
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增公司信息")
    public ResultMessage<Company> add(@RequestBody Company company) {
        boolean result = companyService.insert(company);
        if (result)
            return ResultMessage.success(company);
        return ResultMessage.error();
        }

    /**
     * 删除公司信息
     */
    @DeleteMapping(value = "/del")
    @ApiOperation("删除公司信息")
    public ResultMessage<String> delById(@RequestParam("id") Long id) {
        boolean result = companyService.deleteById(id);
        if (result)
            return ResultMessage.success();
        return ResultMessage.error();
        }

    /**
     * "批量删除公司信息"
     */
    @ResponseBody
    @DeleteMapping(value = "/delete")
    @ApiOperation("批量删除公司信息")
    public ResultMessage<Object> delByIds(String ids) {
        return this.deleteBatchIds(ids, companyService);
    }

    /**
     * 修改公司信息
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改公司信息")
    public ResultMessage<String> update(@RequestBody Company company) {
        boolean result = companyService.updateById(company);
        if (result)
            return ResultMessage.success();
        return ResultMessage.error();
    }

    /**
     * 获取公司信息
     */
    @GetMapping(value = "/get")
    @ApiOperation("查看公司信息")
    public ResultMessage<Company> get(@RequestParam("id") Long id) {
        return ResultMessage.success(companyService.selectById(id));
    }

}

