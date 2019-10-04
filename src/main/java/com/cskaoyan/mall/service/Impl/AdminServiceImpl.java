package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.mapper.PermissionMapper;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.vo.tvo.PasswordVo;
import com.cskaoyan.mall.vo.tvo.ResourceVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public BaseRespVo queryInfo(String token) {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        InfoVo infoVo = new InfoVo();
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(principal);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        Admin admin = admins.get(0);
        infoVo.setAvatar(admin.getAvatar());
        infoVo.setName(principal);
        //查权限ids
        ResourceVo resourceVo = adminMapper.queryRoleIdsByUsername(principal);
        List<String> roles = roleMapper.queryRoleByIds(resourceVo.getRoleIds());
        //查询权限List
        List<String> perms = permissionMapper.queryPermissionsByRoleIds(resourceVo.getRoleIds());
        if (perms.size() == 1 && "*".equals(perms.get(0))) {
            infoVo.setPerms(perms);
        } else {
            List<String> permsList = permissionMapper.queryPerms(perms);
            infoVo.setPerms(permsList);
        }
        infoVo.setRoles(roles);
        BaseRespVo info = BaseRespVo.info(infoVo);
        return info;
    }

    @Override
    public BaseRespVo updatePassword(PasswordVo passwordVo) {
        String oldPassword = passwordVo.getOldPassword();
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        String s = adminMapper.queryPasswordByUsername(principal);
        BaseRespVo baseRespVo = null;
        if (s.equals(oldPassword)){
            if (passwordVo.getNewPassword().equals(passwordVo.getNewPassword2())) {
                //修改密码
                adminMapper.updateByUsername(passwordVo.getNewPassword());
                baseRespVo = BaseRespVo.baseRespErr(0, "成功");
            }else {
                baseRespVo = BaseRespVo.baseRespErr(605, "账号或密码输入错误");
            }

        }else {
            baseRespVo = BaseRespVo.baseRespErr(605, "账号或密码输入错误");
        }
        return baseRespVo;
    }

    @Override
    public boolean queryUsername(String username) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(username);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size() == 0) {
            return false;
        }
        return true;
    }
}
