package com.zt.web.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.base.BaseController;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;
import com.zt.service.api.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 包名       com.zt.mybatis.controller
 * 文件名:    UserController
 * 创建时间:  2019-11-09
 * 描述:      用户 控制器
 *
 * @author Zeti
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户", tags = "接口")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserController extends BaseController {
    @Resource
    private IUserService userService;


    /**
     * 分页查询
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入user")
    public IPage<UserVO> page(Page page, UserVO user) {
        return userService.selectUserPage(page, user);
    }

    @GetMapping("/list")
    public List<UserEntity> selectList() {
        return userService.list();
    }

}
