
package com.zt.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zt.domain.entity.Report;
import com.zt.domain.vo.ReportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 包名   com.mybatis.plus.mapper
 * 文件名:   ReportMapper
 * 创建时间:  2019-09-30
 * 描述:       Mapper 接口
 *
 * @author
 */
@Repository
public interface ReportMapper extends BaseMapper<Report> {

    /**
     * 自定义分页
     *
     * @param page
     * @param report
     * @return
     */
    IPage<ReportVO> selectReportPage(Page page, ReportVO report);

    Report selectId(Integer id);
}
