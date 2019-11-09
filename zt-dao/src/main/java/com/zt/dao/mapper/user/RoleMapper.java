package com.zt.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.entity.RoleEntity;
import com.zt.domain.vo.RoleVO;

/**
 * 包名   com.zt.mybatis.mapper
 * 文件名:   RoleMapper
 * 创建时间:  2019-11-09
 * 描述:       Mapper 接口
 *
 * @author Zeti
 */
public interface RoleMapper extends BaseMapper<RoleEntity> {

    /**
     * 分页查询
     *
     * @param page
     * @param role
     * @return
     */
    IPage<RoleVO> selectRolePage(IPage page, RoleVO role);

}
