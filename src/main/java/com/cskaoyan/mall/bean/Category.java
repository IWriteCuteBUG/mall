package com.cskaoyan.mall.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Category {

    private List<Category> childrens;

    private Integer id;

    private String name;

    private String keywords;

    private String desc;

    private Integer pid;

    private String iconUrl;

    private String picUrl;

    private String level;

    private Byte sortOrder;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date updateTime;

    private Boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(childrens, category.childrens) &&
                Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(keywords, category.keywords) &&
                Objects.equals(desc, category.desc) &&
                Objects.equals(pid, category.pid) &&
                Objects.equals(iconUrl, category.iconUrl) &&
                Objects.equals(picUrl, category.picUrl) &&
                Objects.equals(level, category.level) &&
                Objects.equals(sortOrder, category.sortOrder) &&
                Objects.equals(addTime, category.addTime) &&
                Objects.equals(updateTime, category.updateTime) &&
                Objects.equals(deleted, category.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childrens, id, name, keywords, desc, pid, iconUrl, picUrl, level, sortOrder, addTime, updateTime, deleted);
    }

    public List<Category> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Category> childrens) {
        this.childrens = childrens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
