package com.zt.web.controller;

import com.zt.common.response.Result;
import com.zt.common.response.ResultEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "/api", tags = "测试接口")
public class TestController {


    @GetMapping("/test")
    @ApiOperation(value = "测试", notes = "无参")
    public String test() {
        return "hello, controller";
    }

    @PostMapping("/upload")
    @ApiOperation(value = "上传", notes = "传入urls")
    public Result<Boolean> login(@RequestParam("urls") List<String> urls) {
        String s = Arrays.toString(urls.toArray());
        log.info("请求入参：{}", s);
        return Result.success(ResultEnum.SUCCESS);
    }

    @PostMapping("/index")
    @ApiOperation(value = "主页", notes = "无参")
    public String index() {
        return "index.html";
    }


}
