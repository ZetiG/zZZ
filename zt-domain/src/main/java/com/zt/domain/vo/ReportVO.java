
package com.zt.domain.vo;

import com.zt.domain.entity.Report;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名    com.mybatis.plus.vo;
 * 文件名:   ReportVO
 * 创建时间:  2019-09-30
 * 描述:      视图实体类
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ReportVO对象", description = "ReportVO对象")
public class ReportVO extends Report {
    private static final long serialVersionUID = 1L;

}
