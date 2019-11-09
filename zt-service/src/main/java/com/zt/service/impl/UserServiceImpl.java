package com.zt.service.impl;

import com.zt.dao.mapper.UserMapper;
import com.zt.domain.entity.UserEntity;
import com.zt.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2019/11/9 17:11
 * @Author Zeti
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> selectList() {
        return userMapper.selectList();
    }
}
