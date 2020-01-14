package com.mybatis.plus.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 基础控制器层
 *
 * @Date 2019/9/26 15:42
 * @Author Zeti
 */
@Slf4j
public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    /**
     * 获取request
     *
     * @return HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return this.request;
    }

    /**
     * 获取当前用户
     *
     * @return BladeUser
     */
    public String getToken() {
        return request.getHeader("token");
    }

}
