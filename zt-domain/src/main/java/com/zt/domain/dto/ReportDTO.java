package com.zt.domain.dto;

import com.zt.domain.entity.Report;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名      com.mybatis.plus.dto
 * 文件名:   ReportDTO
 * 创建时间:  2019-09-30
 * 描述:      数据传输对象实体类
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReportDTO extends Report {
    private static final long serialVersionUID = 1L;

}
