package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.AdminExample;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.InfoVo;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.vo.tvo.PasswordVo;
import com.cskaoyan.mall.vo.tvo.ResourceVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    RoleMapper roleMapper;

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
        ArrayList<String> Perms = new ArrayList<>();
        Perms.add("*");
        infoVo.setPerms(Perms);
        ResourceVo resourceVo = adminMapper.queryRoleIdsByUsername(principal);
        List<String> roles = roleMapper.queryRoleByIds(resourceVo.getRoleIds());
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
                baseRespVo = BaseRespVo.baseRespErr(605, "账号密码不对");
            }

        }else {
            baseRespVo = BaseRespVo.baseRespErr(605, "账号密码不对");
        }
        return baseRespVo;
    }
}
