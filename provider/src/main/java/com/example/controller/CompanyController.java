package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Company;
import com.example.result.ResultMessage;
import com.example.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
        Page page = new Page(1,5);
        return ResultMessage.success(companyService.page(page, new QueryWrapper<>(company)));
    }

    /**
    * 获取所有公司信息列表
    */
    @GetMapping(value = "/allList")
    @ApiOperation("所有公司信息列表")
    public ResultMessage<List<Company>> allList() {
        return ResultMessage.success(companyService.list());
    }

    /**
     * 新增公司信息
     */
    @PostMapping(value = "/add")
    @ApiOperation("新增公司信息")
    public ResultMessage<Company> add(@RequestBody Company company) {
        boolean result = companyService.save(company);
        if (result){
            return ResultMessage.success(company);
        }
        return ResultMessage.error();
    }

    /**
     * 删除公司信息
     */
    @DeleteMapping(value = "/del")
    @ApiOperation("删除公司信息")
    public ResultMessage<String> delById(@RequestParam("id") Long id) {
        boolean result = companyService.removeById(id);
        if (result){
            return ResultMessage.success();
        }
        return ResultMessage.error();
        }

    /**
     * 批量删除公司信息
     */
    @ResponseBody
    @DeleteMapping(value = "/delete")
    @ApiOperation("批量删除公司信息")
    public ResultMessage<Object> delByIds(String ids) {
        List idList = Arrays.asList(ids.split(","));
        return companyService.removeByIds(idList) ? ResultMessage.success(ResultMessage.OK, "删除成功") :
                ResultMessage.error(ResultMessage.FAIL, "删除失败");
    }

    /**
     * 修改公司信息
     */
    @PostMapping(value = "/update")
    @ApiOperation("修改公司信息")
    public ResultMessage<String> update(@RequestBody Company company) {
        boolean result = companyService.updateById(company);
        if (result){
            return ResultMessage.success();
        }
        return ResultMessage.error();
    }

    /**
     * 获取公司信息
     */
    @GetMapping(value = "/get")
    @ApiOperation("查看公司信息")
    public ResultMessage<Company> get(@RequestParam("id") Long id) {
        return ResultMessage.success(companyService.getById(id));
    }

}

