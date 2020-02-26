package com.zt.web.controller.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.base.BaseController;
import com.zt.common.response.Result;
import com.zt.common.response.ResultEnum;
import com.zt.domain.dto.UserDTO;
import com.zt.domain.entity.UserEntity;
import com.zt.domain.vo.UserVO;
import com.zt.service.api.IUserService;
import com.zt.web.form.UserForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public IPage<UserVO> page(Page<UserVO> page, UserVO user) {
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
    public boolean login(UserForm userForm) {
        Assert.notNull(userForm, "请求参数不能为空！");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userForm.getUsername(),
                userForm.getPassword());
        try {
            subject.login(usernamePasswordToken);

            request.getSession().setAttribute("userName", userForm.getUsername());

            log.info("登录成功:" + userForm.getUsername());
//            return Result.success(ResultEnum.SUCCESS);
            return true;
        } catch (AuthenticationException exception) {
//            return Result.fail("账号密码错误！");
            return false;
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


}
