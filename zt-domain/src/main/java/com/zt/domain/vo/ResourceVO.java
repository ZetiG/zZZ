package com.zt.domain.vo;

import com.zt.domain.entity.ResourceEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名    com.zt.mybatis.vo;
 * 文件名:   ResourceVO
 * 创建时间:  2019-11-09
 * 描述:      视图实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ResourceVO对象", description = "ResourceVO对象")
public class ResourceVO extends ResourceEntity {
    private static final long serialVersionUID = 1L;

}
