package com.zt.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.entity.UserRole;
import com.zt.domain.vo.UserRoleVO;

/**
 * 包名   com.zt.mybatis.mapper
 * 文件名:   UserRoleMapper
 * 创建时间:  2019-11-09
 * 描述:       Mapper 接口
 *
 * @author Zeti
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 分页查询
     *
     * @param page
     * @param userRole
     * @return
     */
    IPage<UserRoleVO> selectUserRolePage(IPage page, UserRoleVO userRole);

}
