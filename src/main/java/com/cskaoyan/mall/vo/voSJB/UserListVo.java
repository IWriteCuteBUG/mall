package com.cskaoyan.mall.vo.voSJB;

public class UserListVo {
    private int errno;
    DataForUserListVo data;
    String errmsg;

    public UserListVo() {
    }

    public UserListVo(int errno, DataForUserListVo data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "UserListVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public DataForUserListVo getData() {
        return data;
    }

    public void setData(DataForUserListVo data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
