package com.zt.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.zt")
public class ZtWebApplicationTests extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ZtWebApplicationTests.class);
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZtWebApplicationTests.class).run(args);
    }

    @Test
    public void contextLoads() {
    }

}
