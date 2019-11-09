package com.zt.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.domain.entity.ResourceEntity;
import com.zt.domain.vo.ResourceVO;

/**
 * 包名   com.zt.mybatis.service
 * 文件名:   IResourceService
 * 创建时间:  2019-11-09
 * 描述:       服务类
 *
 * @author Zeti
 */

public interface IResourceService extends IService<ResourceEntity> {

    /**
     * 分页查询
     *
     * @param page
     * @param resource
     * @return
     */
    IPage<ResourceVO> selectResourcePage(IPage<ResourceVO> page, ResourceVO resource);

}
