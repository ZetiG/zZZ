package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.dao.mapper.user.ResourceMapper;
import com.zt.domain.entity.ResourceEntity;
import com.zt.domain.vo.ResourceVO;
import com.zt.service.api.IResourceService;
import org.springframework.stereotype.Service;

/**
 * 包名   com.zt.mybatis.service.impl
 * 文件名:   ResourceServiceImpl
 * 创建时间:  2019-11-09
 * 描述:       服务实现类
 *
 * @author Zeti
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourceEntity> implements IResourceService {

    @Override
    public IPage<ResourceVO> selectResourcePage(IPage<ResourceVO> page, ResourceVO resource) {
        return baseMapper.selectResourcePage(page, resource);
    }

}
