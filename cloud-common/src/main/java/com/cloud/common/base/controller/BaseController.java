package com.cloud.common.base.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cloud.common.base.result.ResultMessage;
import com.cloud.common.base.service.SuperService;
import com.cloud.common.util.Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class BaseController {
    public BaseController() {
    }

    public ResultMessage<Object> deleteBatchIds(String ids, SuperService superService) {
        if (StringUtils.isNotBlank(ids)) {
            List idList = Arrays.asList(ids.split(","));
            return superService.deleteBatchIds(idList) ? ResultMessage.success(ResultMessage.OK, "删除成功") : ResultMessage.error(ResultMessage.FAILL, "删除失败");
        } else {
            return ResultMessage.error(ResultMessage.FAILL, "删除失败:传入参数为空");
        }
    }

    public ResultMessage<Object> checkEntity(SuperService superService, HashMap fieldMap) {
        Set keyList = fieldMap.keySet();
        EntityWrapper entityWrapper = new EntityWrapper();
        keyList.stream().forEach((o) -> {
            String value = String.valueOf(o);
            value = Utils.toUnderLineName(value);
            entityWrapper.and(value + "={0}", new Object[]{fieldMap.get(o)});
        });
        int count = superService.selectCount(entityWrapper);
        return count > 0 ? ResultMessage.success("已存在", 1) : ResultMessage.success("不存在", 0);
    }

    public <T> Page<T> getPagination() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if (request == null) {
            throw new RuntimeException("请检查request对象是否注入!");
        } else {
            String pageSize = request.getParameter("pageSize");
            if (StringUtils.isEmpty(pageSize)) {
                pageSize = "20";
            }

            String currentPage = request.getParameter("current");
            if (StringUtils.isEmpty(currentPage)) {
                currentPage = "1";
            }

            Assert.isTrue(StringUtils.isNumeric(pageSize), "分页参数：PAGE_SIZE参数不是数字");
            Assert.isTrue(StringUtils.isNumeric(currentPage), "分页参数：CURRENT_PAGE参数不算数字");
            int size = Integer.valueOf(pageSize);
            int current = Integer.valueOf(currentPage);
            String orderByField = request.getParameter("orderByField");
            String isAsc = request.getParameter("isAsc");
            Page page;
            if (StringUtils.isEmpty(orderByField)) {
                page = new Page(current, size);
                page.setOpenSort(false);
                return page;
            } else {
                page = new Page(current, size, orderByField);
                if ("asc".equals(isAsc)) {
                    page.setAsc(true);
                } else {
                    page.setAsc(false);
                }

                return page;
            }
        }
    }
}
