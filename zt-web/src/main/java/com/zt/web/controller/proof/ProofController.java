package com.zt.web.controller.proof;

import com.mybatis.plus.base.BaseController;
import com.zt.common.utils.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description: 基本校验接口
 *
 * @Date 2020-01-14 23:08
 * @Author Zeti
 */
@RestController
@RequestMapping("/proof")
@Api(value = "/proof", tags = "基本校验接口")
public class ProofController extends BaseController {


    /**
     * 生成图片验证码
     */
    @GetMapping(value = "/captcha")
    @ApiOperation(value = "生成图片验证码", notes = "无参")
    public void getCaptchaCode2(HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HttpSession session = request.getSession();
        ImageUtil imageUtil = new ImageUtil();
        session.setAttribute("code", imageUtil.getCode());
        imageUtil.write(response.getOutputStream());
    }



}
