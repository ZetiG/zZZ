package com.zt.web.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Description: 用于监听没有HttpSession， 没有则创建
 *
 * @Date 2020-01-06 22:58
 * @Author Zeti
 */
@Component
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        // TODO: 2018/12/9
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //将所有的request请求都带上HttpSession
        HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();
    }
}
