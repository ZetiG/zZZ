package com.zt.web.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Description: WebMVC拦截器
 *
 * @Date 2019-11-09 01:24
 * @Author Zeti
 */
@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {

    @Resource
    private CorsInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //处理option请求
        registry.addInterceptor(corsInterceptor)
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/register")
                .excludePathPatterns("/api/loginOut")
                .addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html", "/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/META-INF/resources/webjars/");
    }

}
