package com.zt.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mybatis.plus.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Description: 用户实体类
 *
 * @Date 2019-11-08 23:51
 * @Author Zeti
 */
@Data
@TableName("z_user")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Report对象", description = "Report对象")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 5254043600154399106L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;
}
