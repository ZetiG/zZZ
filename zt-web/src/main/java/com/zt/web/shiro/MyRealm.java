package com.zt.web.shiro;

import com.zt.domain.entity.ResourceEntity;
import com.zt.domain.entity.UserEntity;
import com.zt.service.api.IUserRoleService;
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

import java.util.List;

/**
 * Description: shiro自定义数据源
 *
 * @Date 2019-11-10 16:14
 * @Author Zeti
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserRoleService userRoleService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.fromRealm(getName()).iterator().next().toString();
        if (null != username) {
            UserEntity userEntity = userService.selectByUsername(username);
            if (null != userEntity) {
                List<ResourceEntity> resourceEntityList = userRoleService.selectUserResourceByName(userEntity.getId());
                if (null != resourceEntityList && resourceEntityList.size() > 0) {
                    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                    for (ResourceEntity resourceEntity : resourceEntityList) {
                        //将权限资源添加到用户信息中
                        info.addStringPermission(resourceEntity.getResourceName());
                    }
                    return info;
                }
            }
        }
        return null;
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
