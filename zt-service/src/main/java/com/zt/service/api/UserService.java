package com.zt.service.api;

import com.zt.domain.entity.UserEntity;

import java.util.List;

/**
 * Description: user service
 *
 * @Date 2019/11/9 17:10
 * @Author Zeti
 */
public interface UserService {

    /**
     * 查询所有
     *
     * @return
     */
    List<UserEntity> selectList();
}
