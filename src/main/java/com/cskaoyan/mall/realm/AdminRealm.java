package com.cskaoyan.mall.realm;

import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.vo.adminvo.tvo.ResourceVo;
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

import java.util.List;

@Component
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        //这一步从数据库之中获取权限
        //先从数据库中取出roleids
        ResourceVo resourceVo = adminMapper.queryRoleIdsByUsername(primaryPrincipal);
        //根据int数组查询权限
        List<String> permissions = roleMapper.queryRoleByIds(resourceVo.getRoleIds());
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        //根据pricipal去查询密码
        String password = adminMapper.queryPasswordByUsername(principal);
        return new SimpleAuthenticationInfo(principal, password, this.getName());
    }
}
