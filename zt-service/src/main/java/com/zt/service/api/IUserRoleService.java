package com.zt.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.domain.entity.UserRole;
import com.zt.domain.vo.UserRoleVO;

/**
 * 包名   com.zt.mybatis.service
 * 文件名:   IUserRoleService
 * 创建时间:  2019-11-09
 * 描述:       服务类
 *
 * @author Zeti
 */

public interface IUserRoleService extends IService<UserRole> {

    /**
     * 分页查询
     *
     * @param page
     * @param userRole
     * @return
     */
    IPage<UserRoleVO> selectUserRolePage(IPage<UserRoleVO> page, UserRoleVO userRole);

}
