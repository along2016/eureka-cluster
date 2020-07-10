package com.example.service.impl;

import org.springframework.stereotype.Service;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
