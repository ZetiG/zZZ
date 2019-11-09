package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.dao.mapper.user.UserRoleMapper;
import com.zt.domain.entity.UserRole;
import com.zt.domain.vo.UserRoleVO;
import com.zt.service.api.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 包名   com.zt.mybatis.service.impl
 * 文件名:   UserRoleServiceImpl
 * 创建时间:  2019-11-09
 * 描述:       服务实现类
 *
 * @author Zeti
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public IPage<UserRoleVO> selectUserRolePage(IPage<UserRoleVO> page, UserRoleVO userRole) {
        return baseMapper.selectUserRolePage(page, userRole);
    }

}
