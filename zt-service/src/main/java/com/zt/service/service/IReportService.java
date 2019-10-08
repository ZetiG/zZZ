
package com.zt.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mybatis.plus.base.BaseService;
import com.zt.domain.entity.Report;
import com.zt.domain.vo.ReportVO;

/**
 * 包名   com.mybatis.plus.service
 * 文件名:   IReportService
 * 创建时间:  2019-09-30
 * 描述:       服务类
 *
 * @author
 */

public interface IReportService extends BaseService<Report> {

    /**
     * 分页
     *
     * @param page
     * @param report
     * @return
     */
    IPage<ReportVO> selectReportPage(IPage<ReportVO> page, ReportVO report);

    /**
     * @param id
     * @return
     */
    Report selectById(Integer id);

}
