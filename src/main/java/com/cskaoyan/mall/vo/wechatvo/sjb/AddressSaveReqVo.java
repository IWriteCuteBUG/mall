package com.cskaoyan.mall.vo.wechatvo.sjb;

public class AddressSaveReqVo {
    private String address;
    private int areaId;
    private int cityId;
    private int id;
    private boolean isDefault;
    private String mobile;
    private String name;
    private int provinceId;

    @Override
    public String toString() {
        return "AddressSaveReqVo{" +
                "address='" + address + '\'' +
                ", areaId=" + areaId +
                ", cityId=" + cityId +
                ", id=" + id +
                ", isDefault='" + isDefault + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
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

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean aDefault) {
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

    public AddressSaveReqVo(String address, int areaId, int cityId, int id, boolean isDefault, String mobile, String name, int provinceId) {
        this.address = address;
        this.areaId = areaId;
        this.cityId = cityId;
        this.id = id;
        this.isDefault = isDefault;
        this.mobile = mobile;
        this.name = name;
        this.provinceId = provinceId;
    }

    public AddressSaveReqVo() {
    }
}
