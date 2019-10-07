package com.cskaoyan.mall.vo.wechatvo.sjb;

public class AddressListWechatVo {
    private String detailedAddress;
    private int id;
    private boolean isDefault;
    private String mobile;
    private String name;

    @Override
    public String toString() {
        return "AddressListWechatVo{" +
                "detailedAddress='" + detailedAddress + '\'' +
                ", id=" + id +
                ", isDefault=" + isDefault +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
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

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
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

    public AddressListWechatVo() {
    }

    public AddressListWechatVo(String detailedAddress, int id, boolean isDefault, String mobile, String name) {
        this.detailedAddress = detailedAddress;
        this.id = id;
        this.isDefault = isDefault;
        this.mobile = mobile;
        this.name = name;
    }
}
