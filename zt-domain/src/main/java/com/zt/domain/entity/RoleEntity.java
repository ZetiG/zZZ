package com.zt.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mybatis.plus.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名       com.zt.mybatis.entity
 * 文件名:    RoleEntity
 * 创建时间:  2019-11-09
 * 描述:      实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("z_role")
@ApiModel(value = "Role对象", description = "Role对象")
public class RoleEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名")
    private String roleName;


}
