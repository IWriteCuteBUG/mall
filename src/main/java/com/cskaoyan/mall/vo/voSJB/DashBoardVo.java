package com.cskaoyan.mall.vo.voSJB;


import com.cskaoyan.mall.vo.DashBoardDataVo;

public class DashBoardVo {
    private int errno;
    private DashBoardDataVo data;
    private String errmsg;

    @Override
    public String toString() {
        return "DashBoardVo{" +
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

    public DashBoardDataVo getData() {
        return data;
    }

    public void setData(DashBoardDataVo data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
