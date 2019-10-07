package com.cskaoyan.mall.realm;

import com.cskaoyan.mall.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeChatRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;

    //    微信认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        String password = userMapper.queryPasswordByUserName(principal);
        return new SimpleAuthenticationInfo(principal, password, this.getName());
    }
//    微信授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        simpleAuthorizationInfo.addStringPermission("*");
        return simpleAuthorizationInfo;
    }


}
