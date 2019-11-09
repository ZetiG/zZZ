package com.zt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zt.dao.mapper.user.UserMapper;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;
import com.zt.service.api.IUserService;
import org.springframework.stereotype.Service;

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


}
