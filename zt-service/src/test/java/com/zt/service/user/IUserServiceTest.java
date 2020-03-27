package com.zt.service.user;

import com.zt.domain.entity.UserEntity;
import com.zt.service.BaseTest;
import com.zt.service.api.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2020/3/27 14:35
 * @Author Zeti
 */
@Slf4j
public class IUserServiceTest extends BaseTest {

    @Resource
    private IUserService userService;

    /**
     * 根据用户名查询
     */
    @Test
    public void selectByUsername() {
        UserEntity admin = userService.selectByUsername("admin");
        log.info("selectByUsername=>: {}", admin);
    }
}
