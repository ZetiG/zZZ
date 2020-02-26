package com.zt.web.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.base.BaseController;
import com.zt.domain.vo.RoleResourceVO;
import com.zt.service.api.IRoleResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 包名       com.zt.mybatis.controller
 * 文件名:    RoleResourceController
 * 创建时间:  2019-11-09
 * 描述:     角色权限  控制器
 *
 * @author Zeti
 */
@RestController
@RequestMapping("/role-resource")
@Api(value = "/role-resource", tags = "角色权限接口")
public class RoleResourceController extends BaseController {
    @Resource
    private IRoleResourceService roleResourceService;


    /**
     * 分页查询
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入roleResource")
    public IPage<RoleResourceVO> page(Page<RoleResourceVO> page, RoleResourceVO roleResource) {
        return roleResourceService.selectRoleResourcePage(page, roleResource);
    }


}
