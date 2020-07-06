package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.User;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-01
 */
public interface UserService<T> extends IService<T> {

    User selectById(Long id);
}
