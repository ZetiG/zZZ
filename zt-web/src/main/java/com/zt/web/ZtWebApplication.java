package com.zt.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.zt")
@SpringBootApplication
public class ZtWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZtWebApplication.class, args);
    }

}
