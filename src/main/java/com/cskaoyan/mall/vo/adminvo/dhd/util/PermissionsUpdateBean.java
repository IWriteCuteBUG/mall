package com.cskaoyan.mall.vo.adminvo.dhd.util;

import java.util.Arrays;

public class PermissionsUpdateBean {
    int roleId;
    String[] permissions;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "PermissionsVo2Update{" +
                "roleId=" + roleId +
                ", permissions=" + Arrays.toString(permissions) +
                '}';
    }
}
