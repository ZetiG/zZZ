package com.mybatis.plus.base;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2019/9/26 16:00
 * @Author Zeti
 */
public interface BaseService<T> extends IService<T> {
    /**
     * 逻辑删除
     *
     * @param id id集合(逗号分隔)
     * @return
     */
    boolean deleteLogic(Integer id);


}
