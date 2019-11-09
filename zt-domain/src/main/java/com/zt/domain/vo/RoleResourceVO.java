package com.zt.domain.vo;

import com.zt.domain.entity.RoleResource;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名    com.zt.mybatis.vo;
 * 文件名:   RoleResourceVO
 * 创建时间:  2019-11-09
 * 描述:      视图实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "RoleResourceVO对象", description = "RoleResourceVO对象")
public class RoleResourceVO extends RoleResource {
    private static final long serialVersionUID = 1L;

}
