package com.zt.web.shiro;

import com.zt.domain.entity.UserEntity;
import com.zt.service.api.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description: shiro自定义数据源
 *
 * @Date 2019-11-10 16:14
 * @Author Zeti
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        UserEntity userEntity = userService.selectByUsername(username);
        String passwordInDB = userEntity.getPassword();
        String salt = userEntity.getSalt();
        return new SimpleAuthenticationInfo(username, passwordInDB, ByteSource.Util.bytes(salt), getName());
    }
}
