package com.zt.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zt.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 包名   com.mybatis.plus.mapper
 * 文件名:   ReportMapper
 * 创建时间:  2019-09-30
 * 描述:       Mapper 接口
 *
 * @author
 */
@Repository
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 查询所有
     *
     * @return
     */
    List<UserEntity> selectList();

}
