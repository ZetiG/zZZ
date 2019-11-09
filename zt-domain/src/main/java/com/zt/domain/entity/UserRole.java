package com.zt.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mybatis.plus.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名       com.zt.mybatis.entity
 * 文件名:    UserRole
 * 创建时间:  2019-11-09
 * 描述:      实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("z_user_role")
@ApiModel(value = "UserRole对象", description = "UserRole对象")
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;


    private Integer userId;

    private Integer roleId;


}
