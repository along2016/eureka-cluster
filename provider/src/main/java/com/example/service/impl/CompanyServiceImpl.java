package com.example.service.impl;

import org.springframework.stereotype.Service;
import com.example.entity.Company;
import com.example.mapper.CompanyMapper;
import com.example.service.CompanyService;
import com.f00lish.xcloud.common.base.service.impl.SuperServiceImpl;
import com.f00lish.xcloud.common.base.mapper.SuperMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;


/**
 * <p>
 * 公司信息 服务实现类
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-06
 */
@Service
public class CompanyServiceImpl extends SuperServiceImpl<SuperMapper<Company>,Company> implements CompanyService {

    /*
    @Override
    @CacheEvict(value="otherCache",allEntries = true)
    public boolean insert(CompanyVO entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value="otherCache",allEntries = true)
    public boolean updateById(CompanyVO entity) {
        return super.updateById(entity);
    }
    **/

    @Override
    @CacheEvict(value="otherCache",allEntries = true)
    public boolean deleteById(Serializable id) {
        return super.deleteById(id);
    }
}
