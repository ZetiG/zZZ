package com.zt.domain.dto;

import com.zt.domain.entity.ResourceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名      com.zt.mybatis.dto
 * 文件名:   ResourceDTO
 * 创建时间:  2019-11-09
 * 描述:      数据传输对象实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResourceDTO extends ResourceEntity {
    private static final long serialVersionUID = 1L;

}
