package com.zt.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.domain.entity.RoleEntity;
import com.zt.domain.vo.RoleVO;

/**
 * 包名   com.zt.mybatis.service
 * 文件名:   IRoleService
 * 创建时间:  2019-11-09
 * 描述:       服务类
 *
 * @author Zeti
 */

public interface IRoleService extends IService<RoleEntity> {

    /**
     * 分页查询
     *
     * @param page
     * @param role
     * @return
     */
    IPage<RoleVO> selectRolePage(IPage<RoleVO> page, RoleVO role);

}
