package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.dao.mapper.user.RoleMapper;
import com.zt.domain.entity.RoleEntity;
import com.zt.domain.vo.RoleVO;
import com.zt.service.api.IRoleService;
import org.springframework.stereotype.Service;

/**
 * 包名   com.zt.mybatis.service.impl
 * 文件名:   RoleServiceImpl
 * 创建时间:  2019-11-09
 * 描述:       服务实现类
 *
 * @author Zeti
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements IRoleService {

    @Override
    public IPage<RoleVO> selectRolePage(IPage<RoleVO> page, RoleVO role) {
        return baseMapper.selectRolePage(page, role);
    }

}
