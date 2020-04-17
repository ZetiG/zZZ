package com.zt.common.configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.actuate.env.EnvironmentEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.spring.web.json.Json;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.UiConfiguration;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


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
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = getFastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setDefaultCharset(Charset.defaultCharset());
//        fastJsonHttpMessageConverter.setFastJsonConfig(getFastJsonConfig());
        return new HttpMessageConverters(fastJsonHttpMessageConverter);
//        return new HttpMessageConverters();
    }

    @Bean
    public FastJsonHttpMessageConverter getFastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        fastMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        fastMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        fastMediaTypes.add(MediaType.TEXT_HTML);
        fastMediaTypes.add(new MediaType("application", "vnd.spring-boot.actuator.v2+json"));
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        FastJsonConfig fastJsonConfig = getFastJsonConfig();
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return fastConverter;
    }

    @Bean
    public FastJsonConfig getFastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        SerializeConfig serializeConfig = new SerializeConfig();
        NameFilter nameFilter = (object, name, value) -> name;
        serializeConfig.addFilter(UiConfiguration.class, nameFilter);
        serializeConfig.addFilter(SwaggerResource.class, nameFilter);
        serializeConfig.addFilter(MetricsEndpoint.MetricResponse.class, nameFilter);
        serializeConfig.addFilter(EnvironmentEndpoint.EnvironmentDescriptor.class, nameFilter);
        serializeConfig.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        fastJsonConfig.setSerializeConfig(serializeConfig);
        fastJsonConfig.setDateFormat(JSON.DEFFAULT_DATE_FORMAT);
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        return fastJsonConfig;
    }

}
