package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.dao.mapper.user.ResourceMapper;
import com.zt.dao.mapper.user.RoleResourceMapper;
import com.zt.dao.mapper.user.UserRoleMapper;
import com.zt.domain.entity.ResourceEntity;
import com.zt.domain.entity.RoleResource;
import com.zt.domain.entity.UserRole;
import com.zt.domain.vo.UserRoleVO;
import com.zt.service.api.IUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private RoleResourceMapper roleResourceMapper;
    @Resource
    private ResourceMapper resourceMapper;

    @Override
    public IPage<UserRoleVO> selectUserRolePage(IPage<UserRoleVO> page, UserRoleVO userRole) {
        return baseMapper.selectUserRolePage(page, userRole);
    }

    @Override
    public List<ResourceEntity> selectUserResourceByName(Integer userId) {
        if (userId == null) return null;
        List<UserRole> userRoles = baseMapper.selectByUserId(userId);
        if (null != userRoles && userRoles.size() > 0) {
            List<ResourceEntity> resourceList = new ArrayList<>();
            for (UserRole userRole : userRoles) {
                List<RoleResource> roleResources = roleResourceMapper.selectByRoleId(userRole.getRoleId());
                if (null != roleResources && roleResources.size() > 0) {
                    for (RoleResource roleResource : roleResources) {
                        ResourceEntity resourceEntity = resourceMapper.selectById(roleResource.getResourceId());
                        resourceList.add(resourceEntity);
                    }
                }
            }
            return resourceList;
        }
        return null;
    }

}
