package com.zt.web.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.base.BaseController;
import com.zt.domain.vo.ResourceVO;
import com.zt.service.api.IResourceService;
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
 * 文件名:    ResourceController
 * 创建时间:  2019-11-09
 * 描述:      资源权限 控制器
 *
 * @author Zeti
 */
@RestController
@RequestMapping("/resource")
@Api(value = "/resource", tags = "资源权限接口")
public class ResourceController extends BaseController {
    @Resource
    private IResourceService resourceService;


    /**
     * 分页查询
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入resource")
    public IPage<ResourceVO> page(Page<ResourceVO> page, ResourceVO resource) {
        return resourceService.selectResourcePage(page, resource);
    }


}
