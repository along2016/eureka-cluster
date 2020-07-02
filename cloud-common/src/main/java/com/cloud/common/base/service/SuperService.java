package com.cloud.common.base.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface SuperService<T> extends IService<T> {

    boolean insertByVO(T var1);

    boolean updateByVO(T var1);

    List<Object> selectListByVO(Wrapper<Object> var1);

    Page<Object> selectPageByVO(Page<T> page, Wrapper<Object> wrapper);

}
