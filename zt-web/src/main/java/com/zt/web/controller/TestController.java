package com.zt.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2019/9/26 15:46
 * @Author Zeti
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        System.out.println("测试-->：");
        return "hello, controller";
    }

}
