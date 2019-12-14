package com.zt.web.config;

import com.zt.web.listener.SessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: spring 配置
 *
 * @Date 2019/12/14 15:23
 * @Author Zeti
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ServletListenerRegistrationBean<SessionListener> servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<SessionListener> listenerRegistrationBean =
                new ServletListenerRegistrationBean<>();
        listenerRegistrationBean.setListener(new SessionListener());
        return listenerRegistrationBean;
    }

}
