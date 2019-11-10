package com.zt.service.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zt.domain.dto.UserDTO;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;

/**
 * 包名   com.zt.mybatis.service
 * 文件名:   IUserService
 * 创建时间:  2019-11-09
 * 描述:       服务类
 *
 * @author Zeti
 */

public interface IUserService extends IService<UserEntity> {

    /**
     * 分页查询
     *
     * @param page
     * @param user
     * @return
     */
    IPage<UserVO> selectUserPage(IPage<UserVO> page, UserVO user);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    UserEntity selectByUsername(String username);

    /**
     * 新增
     *
     * @param userDTO
     * @return
     */
    boolean add(UserDTO userDTO);

}
