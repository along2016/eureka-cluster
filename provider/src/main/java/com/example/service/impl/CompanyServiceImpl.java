package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Company;
import com.example.mapper.CompanyMapper;
import com.example.service.CompanyService;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 公司信息 服务实现类
 * </p>
 *
 * @author wangjiliang
 * @since 2020-07-06
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

}
