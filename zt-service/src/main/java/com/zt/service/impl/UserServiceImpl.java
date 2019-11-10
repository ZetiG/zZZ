package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.dao.mapper.user.UserMapper;
import com.zt.domain.dto.UserDTO;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;
import com.zt.service.api.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 包名   com.zt.mybatis.service.impl
 * 文件名:   UserServiceImpl
 * 创建时间:  2019-11-09
 * 描述:       服务实现类
 *
 * @author Zeti
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Override
    public IPage<UserVO> selectUserPage(IPage<UserVO> page, UserVO user) {
        return baseMapper.selectUserPage(page, user);
    }

    @Override
    public UserEntity selectByUsername(String username) {
        if (username == null) return null;
        return baseMapper.selectByUsername(username);
    }

    @Override
    @Transactional
    public boolean add(UserDTO userDTO) {
        return baseMapper.insert(userDTO) > 0;
    }


}
