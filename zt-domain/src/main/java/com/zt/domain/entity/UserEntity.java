package com.zt.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mybatis.plus.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 包名       com.zt.mybatis.entity
 * 文件名:    UserEntity
 * 创建时间:  2019-11-09
 * 描述:      实体类
 *
 * @author Zeti
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("z_user")
@ApiModel(value = "User对象", description = "User对象")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;


    private String username;

    private String password;

    private String salt;

}
