package com.zt.domain.wrapper;

import com.mybatis.plus.support.BaseEntityWrapper;
import com.zt.domain.entity.ResourceEntity;
import com.zt.domain.vo.ResourceVO;
import lombok.AllArgsConstructor;

/**
 * 包名   com.zt.mybatis.wrapper
 * 文件名:   ResourceWrapper
 * 创建时间:  2019-11-09
 * 描述:      包装类,返回视图层所需的字段
 *
 * @author Zeti
 */
@AllArgsConstructor
public class ResourceWrapper extends BaseEntityWrapper<ResourceEntity, ResourceVO> {


    @Override
    public ResourceVO entityVO(ResourceEntity entity) {
        return null;
    }
}
