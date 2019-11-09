package com.zt.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;

/**
 * 包名   com.zt.mybatis.mapper
 * 文件名:   UserMapper
 * 创建时间:  2019-11-09
 * 描述:       Mapper 接口
 *
 * @author Zeti
 */
public interface UserMapper extends BaseMapper<UserEntity> {

    /**
     * 分页查询
     *
     * @param page
     * @param user
     * @return
     */
    IPage<UserVO> selectUserPage(IPage page, UserVO user);

}
