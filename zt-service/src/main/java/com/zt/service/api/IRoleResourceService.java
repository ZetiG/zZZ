package com.zt.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.domain.entity.RoleResource;
import com.zt.domain.vo.RoleResourceVO;

/**
 * 包名   com.zt.mybatis.service
 * 文件名:   IRoleResourceService
 * 创建时间:  2019-11-09
 * 描述:       服务类
 *
 * @author Zeti
 */

public interface IRoleResourceService extends IService<RoleResource> {

    /**
     * 分页查询
     *
     * @param page
     * @param roleResource
     * @return
     */
    IPage<RoleResourceVO> selectRoleResourcePage(IPage<RoleResourceVO> page, RoleResourceVO roleResource);

}
