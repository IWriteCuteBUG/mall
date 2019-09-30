package com.cskaoyan.mall.bean;

import java.util.List;

public class InfoVo {
    /*
    "roles":[
            "超级管理员"
        ],
        "name":"admin123",
        "perms":[
            "*"
        ],
        "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif"
    * */
    private List roles;
    private String name;
    private List perms;
    private String avatar;

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPerms() {
        return perms;
    }

    public void setPerms(List perms) {
        this.perms = perms;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
