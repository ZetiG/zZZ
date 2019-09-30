
package com.zt.domain.wrapper;

import com.mybatis.plus.support.BaseEntityWrapper;
import com.zt.domain.entity.Report;
import com.zt.domain.vo.ReportVO;
import lombok.AllArgsConstructor;

/**
 * 包名   com.mybatis.plus.wrapper
 * 文件名:   ReportWrapper
 * 创建时间:  2019-09-30
 * 描述:      包装类,返回视图层所需的字段
 *
 * @author
 */
@AllArgsConstructor
public class ReportWrapper extends BaseEntityWrapper<Report, ReportVO> {


    @Override
    public ReportVO entityVO(Report report) {
//        ReportVO copy = BeanUtil.copy(report, ReportVO.class);
        ReportVO reportVO = new ReportVO();
        return reportVO;
    }

}
