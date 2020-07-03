package com.example.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cloud.common.base.mapper.SuperMapper;
import com.cloud.common.base.service.impl.SuperServiceImpl;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.io.Serializable;


/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>,User> implements UserService {

    @Override
    @CacheEvict(value="otherCache",allEntries = true)
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }
}
