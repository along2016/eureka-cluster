package com.cloud.common.base.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cloud.common.base.entity.BaseEntity;
import com.cloud.common.base.service.SuperService;
import com.cloud.common.util.Utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class SuperServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {

    @Override
    public boolean insertByVO(Object objectVO) {
        Long id = ((BaseEntity)objectVO).getId();
        if (id != null && id == 0L) {
            ((BaseEntity)objectVO).setId(null);
        }

        T t = this.getNewInstance(objectVO);
        boolean flag = super.insert(t);
        ((BaseEntity)objectVO).setId(((BaseEntity)t).getId());
        return flag;
    }

    @Override
    public boolean updateByVO(T objectVO) {
        T t = this.getNewInstance(objectVO);
        return super.updateById(t);
    }

    @Override
    public List<Object> selectListByVO(Wrapper<Object> wrapper) {
        EntityWrapper entityWrapper = (EntityWrapper)wrapper;
        Object objectVO = wrapper.getEntity();
        T t = this.getNewInstance(objectVO);
        entityWrapper.setEntity(t);
        return this.selectList(entityWrapper);
    }

    @Override
    public Page<Object> selectPageByVO(Page<T> page, Wrapper<Object> wrapper) {
        EntityWrapper entityWrapper = (EntityWrapper)wrapper;
        Object objectVO = wrapper.getEntity();
        T t = this.getNewInstance(objectVO);
        entityWrapper.setEntity(t);
        return this.selectPage(page, entityWrapper);
    }

    private T getNewInstance(Object objectVO) {
        try {
            T t = (T) this.getMyClass().newInstance();
            Utils.copyProperties(objectVO, t, new String[0]);
            return t;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }

    private Class getMyClass() {
        System.out.println(this.getClass());
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] ptype = ((ParameterizedType)type).getActualTypeArguments();
            Type[] var3 = ptype;
            int var4 = ptype.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                Type cls = var3[var5];
                if (!(cls instanceof ParameterizedType)) {
                    return (Class)cls;
                }
            }
        }

        return Object.class;
    }
}
