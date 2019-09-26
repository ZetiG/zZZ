package com.mybatis.plus.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.validation.annotation.Validated;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2019/9/26 16:01
 * @Author Zeti
 */
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {
    private Class<T> modelClass;

    public BaseServiceImpl() {
        Type type = this.getClass().getGenericSuperclass();
        this.modelClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[1];
    }

    @Override
    public boolean deleteLogic(Integer id) {
        return super.removeById(id);
    }

    @Override
    public boolean save(T entity) {
        return super.save(entity);
    }

    @Override
    public boolean updateById(T entity) {
        return super.updateById(entity);
    }
}