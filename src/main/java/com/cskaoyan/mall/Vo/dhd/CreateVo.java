package com.cskaoyan.mall.Vo.dhd;

public class CreateVo {
    String addTime;
    String desc;
    int id;
    String name;
    String updateTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "CreateVo{" +
                "addTime='" + addTime + '\'' +
                ", desc='" + desc + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
