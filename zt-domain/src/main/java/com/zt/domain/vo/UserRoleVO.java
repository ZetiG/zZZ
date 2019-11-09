package com.zt.domain.vo;

import com.zt.domain.entity.UserRole;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名    com.zt.mybatis.vo;
 * 文件名:   UserRoleVO
 * 创建时间:  2019-11-09
 * 描述:      视图实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserRoleVO对象", description = "UserRoleVO对象")
public class UserRoleVO extends UserRole {
    private static final long serialVersionUID = 1L;

}
