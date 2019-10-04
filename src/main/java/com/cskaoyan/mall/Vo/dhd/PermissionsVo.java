package com.cskaoyan.mall.vo.dhd;

import com.cskaoyan.mall.vo.dhd.util.SystemPermission;

import java.util.Arrays;
import java.util.List;


public class PermissionsVo {
   private String[] assignedPermissions;
   private List<SystemPermission>  systemPermissions;

    public String[] getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(String[] assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public List<SystemPermission> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List<SystemPermission> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }

    @Override
    public String toString() {
        return "PermissionsVo{" +
                "assignedPermissions=" + Arrays.toString(assignedPermissions) +
                ", systemPermissions=" + systemPermissions +
                '}';
    }
}