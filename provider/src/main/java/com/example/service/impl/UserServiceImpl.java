package com.example.service.impl;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-01
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean insert(User entity) {
        return false;
    }
}
