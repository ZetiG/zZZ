package com.zt.web.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Description: 用户表单接收类
 *
 * @Date 2019-11-10 14:55
 * @Author Zeti
 */
@Data
@ApiModel(value = "UserForm", description = "用户表单接收类")
public class UserForm {

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

}
