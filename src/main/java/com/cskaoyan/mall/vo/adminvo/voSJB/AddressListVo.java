package com.cskaoyan.mall.vo.adminvo.voSJB;

public class AddressListVo {
    private int errno;
    private DataForAddressListVo data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public DataForAddressListVo getData() {
        return data;
    }

    public void setData(DataForAddressListVo data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "AddressListVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public AddressListVo(int errno, DataForAddressListVo data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public AddressListVo() {
    }
}
