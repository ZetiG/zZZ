package com.zt.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.mybatis.plus.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 包名       com.zt.mybatis.entity
 * 文件名:    RoleResource
 * 创建时间:  2019-11-09
 * 描述:      实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("z_role_resource")
@ApiModel(value = "RoleResource对象", description = "RoleResource对象")
public class RoleResource extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色Id")
    private Integer roleId;

    @ApiModelProperty(value = "资源Id")
    private Integer resourceId;


}
