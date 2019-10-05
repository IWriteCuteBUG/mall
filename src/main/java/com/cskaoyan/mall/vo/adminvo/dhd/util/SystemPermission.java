package com.cskaoyan.mall.vo.adminvo.dhd.util;

import java.util.List;

public class SystemPermission {
    int pid;
    int parent_id;
    String id;
    String api;
    String label;
    List<SystemPermission> children;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }



    public List<SystemPermission> getChildren() {
        return children;
    }

    public void setChildren(List<SystemPermission> children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "SystemPermission{" +
                "pid=" + pid +
                ", parent_id=" + parent_id +
                ", id='" + id + '\'' +
                ", api='" + api + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
