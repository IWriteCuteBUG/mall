package com.cskaoyan.mall.vo.adminvo.voSJB;

public class CollectListVo {
    private int errno;
    private DataForCollectListVo data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public DataForCollectListVo getData() {
        return data;
    }

    public void setData(DataForCollectListVo data) {
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
        return "CollectListVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public CollectListVo(int errno, DataForCollectListVo data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public CollectListVo() {
    }
}
