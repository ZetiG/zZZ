package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.dao.mapper.user.RoleResourceMapper;
import com.zt.domain.entity.RoleResource;
import com.zt.domain.vo.RoleResourceVO;
import com.zt.service.api.IRoleResourceService;
import org.springframework.stereotype.Service;

/**
 * 包名   com.zt.mybatis.service.impl
 * 文件名:   RoleResourceServiceImpl
 * 创建时间:  2019-11-09
 * 描述:       服务实现类
 *
 * @author Zeti
 */
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements IRoleResourceService {

    @Override
    public IPage<RoleResourceVO> selectRoleResourcePage(IPage<RoleResourceVO> page, RoleResourceVO roleResource) {
        return baseMapper.selectRoleResourcePage(page, roleResource);
    }

}
