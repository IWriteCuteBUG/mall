package com.cskaoyan.mall.vo.wechatvo.sjb;

public class AddressDetailVo {
    private String address;
    private int areaId;
    private String areaName;
    private int cityId;
    private String cityName;
    private int id;
    private boolean isDefault;
    private String mobile;
    private String name;
    private int provinceId;
    private String provinceName;

    @Override
    public String toString() {
        return "AddressDetailVo{" +
                "address='" + address + '\'' +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", id=" + id +
                ", isDefault=" + isDefault +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public AddressDetailVo(String address, int areaId, String areaName, int cityId, String cityName, int id, boolean isDefault, String mobile, String name, int provinceId, String provinceName) {
        this.address = address;
        this.areaId = areaId;
        this.areaName = areaName;
        this.cityId = cityId;
        this.cityName = cityName;
        this.id = id;
        this.isDefault = isDefault;
        this.mobile = mobile;
        this.name = name;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public AddressDetailVo() {
    }
}
