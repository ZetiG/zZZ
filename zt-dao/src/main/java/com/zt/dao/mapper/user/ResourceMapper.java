package com.zt.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.entity.ResourceEntity;
import com.zt.domain.vo.ResourceVO;

/**
 * 包名   com.zt.mybatis.mapper
 * 文件名:   ResourceMapper
 * 创建时间:  2019-11-09
 * 描述:       Mapper 接口
 *
 * @author Zeti
 */
public interface ResourceMapper extends BaseMapper<ResourceEntity> {

    /**
     * 分页查询
     *
     * @param page
     * @param resource
     * @return
     */
    IPage<ResourceVO> selectResourcePage(IPage page, ResourceVO resource);

}
