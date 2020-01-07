package com.zt.common.configuration;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.json.Json;

import java.nio.charset.Charset;

/**
 * Description: FastJson配置
 *
 * @Date 2019/12/16 15:34
 * @Author Zeti
 */
@Configuration
public class FastJsonConverterConfig {

    @Bean
    public HttpMessageConverters mmFastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new ExtendedFastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.defaultCharset());
        FastJsonConfig config = new FastJsonConfig();
        config.getSerializeConfig().put(Json.class, new SwaggerJsonSerializer());
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
//        return new HttpMessageConverters();
    }

}
