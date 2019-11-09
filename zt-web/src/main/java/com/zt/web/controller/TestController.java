package com.zt.web.controller;

import com.zt.domain.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * Description: (用一句话描述该文件做什么)
 *
 * @Date 2019/9/26 15:46
 * @Author Zeti
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test() {
        System.out.println("测试-->：");
        return "hello, controller";
    }

    @GetMapping("/")
    public String hello() {
        return "index.html";
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserEntity userEntity) {
        log.info(userEntity.getUsername());
        log.info(userEntity.getPassword());
        return true;
    }

    @PostMapping("/index")
    public String index() {
        return "index.html";
    }


}
