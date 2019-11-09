package com.zt.common.swagger;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Swagger2Config配置参数信息
 *
 * @Date 2019/10/8 16:12
 * @Author Zeti
 */
@Data
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    /**
     * swagger会解析的包路径
     **/
    private String basePackage = "com.zt";

    /**
     * swagger会解析的url规则
     **/
    private List<String> basePath = new ArrayList<>();

    /**
     * 在basePath基础上需要排除的url规则
     **/
    private List<String> excludePath = new ArrayList<>();

    /**
     * 标题
     **/
    private String title = "zZZ项目接口文档";

    /**
     * 描述
     **/
    private String description = "swagger2接口文档";

    /**
     * 版本
     **/
    private String version = "1.0";

    /**
     * 许可证
     **/
    private String license = "";

    /**
     * 许可证URL
     **/
    private String licenseUrl = "";

    /**
     * 服务条款URL
     **/
    private String termsOfServiceUrl = "";

    /**
     * host信息
     **/
    private String host = "localhost";

    /**
     * 联系人信息
     */
    private Contact contact = new Contact();

    @Data
    @NoArgsConstructor
    public static class Contact {

        /**
         * 联系人
         **/
        private String name = "Zeti";

        /**
         * 联系人url
         **/
        private String url = "";

        /**
         * 联系人email
         **/
        private String email = "zmk95511@163.com";

    }

}
