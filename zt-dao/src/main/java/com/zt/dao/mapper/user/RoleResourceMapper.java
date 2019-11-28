package com.zt.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.entity.RoleResource;
import com.zt.domain.vo.RoleResourceVO;

import java.util.List;

/**
 * 包名   com.zt.mybatis.mapper
 * 文件名:   RoleResourceMapper
 * 创建时间:  2019-11-09
 * 描述:       Mapper 接口
 *
 * @author Zeti
 */
public interface RoleResourceMapper extends BaseMapper<RoleResource> {

    /**
     * 分页查询
     *
     * @param page
     * @param roleResource
     * @return
     */
    IPage<RoleResourceVO> selectRoleResourcePage(IPage page, RoleResourceVO roleResource);

    /**
     * 根据角色id查询对应权限
     *
     * @param roleId
     * @return
     */
    List<RoleResource> selectByRoleId(Integer roleId);

}
