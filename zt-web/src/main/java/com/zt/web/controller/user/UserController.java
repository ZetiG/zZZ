package com.zt.web.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.base.BaseController;
import com.zt.common.response.Result;
import com.zt.common.response.ResultEnum;
import com.zt.common.utils.ImageUtil;
import com.zt.common.utils.VerifyCodeUtil;
import com.zt.common.validatecode.ValidateCode;
import com.zt.domain.dto.UserDTO;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;
import com.zt.service.api.IUserService;
import com.zt.web.form.UserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * 包名       com.zt.mybatis.controller
 * 文件名:    UserController
 * 创建时间:  2019-11-09
 * 描述:      用户 控制器
 *
 * @author Zeti
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "用户接口")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @Resource
    private HttpServletRequest request;


    /**
     * 分页查询
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页", notes = "传入user")
    public IPage<UserVO> page(Page page, UserVO user) {
        return userService.selectUserPage(page, user);
    }

    /**
     * 查询所有
     */
    @GetMapping("/list")
    @ApiOperation(value = "查询所有", notes = "无参数")
    public List<UserEntity> selectList() {
        return userService.list();
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册", notes = "传入userForm")
    public boolean register(UserForm userForm) {
        String username = userForm.getUsername();
        Assert.notNull(userForm, "请求参数不能为空！");
        Assert.isNull(userService.selectByUsername(username), "该用户名已存在");

        // 生成盐,默认长度 16 位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 设置 hash 算法迭代次数
        int times = 2;
        // 得到 hash 后的密码
        String encodedPassword = new SimpleHash("md5", userForm.getPassword(), salt, times).toString();
        //
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(username);
        userDTO.setPassword(encodedPassword);
        userDTO.setSalt(salt);
        return userService.add(userDTO);
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "传入userForm")
    public Result login(UserForm userForm) {
        Assert.notNull(userForm, "请求参数不能为空！");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userForm.getUsername(),
                userForm.getPassword());
        try {
            subject.login(usernamePasswordToken);

            request.getSession().setAttribute("userName", userForm.getUsername());

            log.info("登录成功:" + userForm.getUsername());
            return Result.success(ResultEnum.SUCCESS);
        } catch (AuthenticationException exception) {
            return Result.fail("账号密码错误！");
//            throw new IllegalArgumentException("账号密码错误！");
        }
    }

    /**
     * 退出
     */
    @GetMapping("/loginOut")
    @ApiOperation(value = "退出", notes = "无参数")
    public boolean loginOut() {
        try {
            SecurityUtils.getSubject().logout();
            return true;
        } catch (Exception e) {
            log.info("退出失败:" + e);
            throw new IllegalArgumentException("退出失败, 请重试！");
        }
    }

    /**
     * 生成图片验证码
     */
    @GetMapping(value = "/captcha")
    public void getCaptchaCode(HttpServletResponse response) throws IOException {
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        // 禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        ValidateCode vCode = new ValidateCode(100, 35, 4, 15);

        String captcha = getCookie(request, "captcha");
        // 绑定客户端和验证码，写cookie
        if (StringUtils.isBlank(captcha)) {
            captcha = String.valueOf(2);
            response.setHeader("Set-Cookie", "captcha" + "=" + captcha + ";Path=/;HTTPOnly");
        }
        vCode.write(response.getOutputStream());
    }

    /**
     * 生成图片验证码2
     */
    @GetMapping(value = "/captcha2")
    public void getCaptchaCode2(HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HttpSession session = request.getSession();
        ImageUtil imageUtil = new ImageUtil(120, 40, 5,30);
        session.setAttribute("code", imageUtil.getCode());
        imageUtil.write(response.getOutputStream());
    }

    private  String getCookie(HttpServletRequest request, String cookieName){
        Cookie[] cookies = request.getCookies();
        if(null == cookies || cookies.length == 0)
            return null;
        for(Cookie cookie : cookies){
            if(cookieName.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return null;
    }

}
