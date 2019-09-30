
package com.zt.service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.base.BaseServiceImpl;
import com.zt.dao.mapper.ReportMapper;
import com.zt.domain.entity.Report;
import com.zt.domain.vo.ReportVO;
import com.zt.service.service.IReportService;
import org.springframework.stereotype.Service;

/**
 * 包名   com.mybatis.plus.service.impl
 * 文件名:   ReportServiceImpl
 * 创建时间:  2019-09-30
 * 描述:       服务实现类
 *
 * @author
 */
@Service
public class ReportServiceImpl extends BaseServiceImpl<ReportMapper, Report> implements IReportService {

    @Override
    public IPage<ReportVO> selectReportPage(Page<ReportVO> page, ReportVO report) {
        return baseMapper.selectReportPage(page, report);
    }

    @Override
    public Report selectById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Report selectId(Integer id) {
        return baseMapper.selectId(id);
    }

}
