package com.zt.web.controller;

import com.zt.common.response.Result;
import com.zt.common.response.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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
        return "hello, controller";
    }

    @GetMapping("/")
    public String hello() {
        return "index.html";
    }

    @PostMapping("/upload")
    public Result<Boolean> login(@RequestParam("urls") List<String> urls) {
        String s = Arrays.toString(urls.toArray());
        System.out.println(s);
        return Result.success(ResultEnum.SUCCESS);
    }

    @PostMapping("/index")
    public String index() {
        return "index.html";
    }


}
