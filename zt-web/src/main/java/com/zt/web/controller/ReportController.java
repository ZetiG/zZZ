
package com.zt.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.base.BaseController;
import com.zt.domain.entity.Report;
import com.zt.domain.vo.ReportVO;
import com.zt.service.service.IReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 包名       com.mybatis.plus.controller
 * 文件名:    ReportController
 * 创建时间:  2019-09-30
 * 描述:       控制器
 *
 * @author
 */
@RestController
@RequestMapping("/report")
@Api(value = "", tags = "接口")
public class ReportController extends BaseController {

    @Resource
    private IReportService reportService;

    /**
     * 自定义分页
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入report")
    public IPage<ReportVO> page(Page page, ReportVO report) {
        IPage<ReportVO> pages = reportService.selectReportPage(page, report);
        return pages;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "分页", notes = "传入report")
    public Report selectById(@PathVariable Integer id) {
        return reportService.selectById(id);
    }

    @GetMapping("/test/{id}")
    @ApiOperation(value = "分页", notes = "传入report")
    public Report selectId(@PathVariable Integer id) {
        return reportService.selectId(id);
    }

    /**
     * 新增
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增", notes = "传入report")
    public boolean save(@Valid @RequestBody Report report) {
        return reportService.save(report);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改", notes = "传入report")
    public boolean update(@Valid @RequestBody Report report) {
        return reportService.updateById(report);
    }

    /**
     * 新增或修改
     */
    @PostMapping("/submit")
    @ApiOperation(value = "新增或修改", notes = "传入report")
    public boolean submit(@Valid @RequestBody Report report) {
        return reportService.saveOrUpdate(report);
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ApiOperation(value = "逻辑删除", notes = "传入id")
    public boolean remove(@ApiParam(value = "主键", required = true) @RequestParam String id) {
        return reportService.deleteLogic(Integer.parseInt(id));
    }


}
