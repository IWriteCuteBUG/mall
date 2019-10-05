package com.cskaoyan.mall.vo.adminvo.voSJB;

public class FootprintListVo {
    private int errno;
    private DataForFootprintListVo data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public DataForFootprintListVo getData() {
        return data;
    }

    public void setData(DataForFootprintListVo data) {
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
        return "FootprintListVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public FootprintListVo(int errno, DataForFootprintListVo data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public FootprintListVo() {
    }
}
