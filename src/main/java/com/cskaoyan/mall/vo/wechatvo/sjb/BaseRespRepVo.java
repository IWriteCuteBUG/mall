package com.cskaoyan.mall.vo.wechatvo.sjb;

public class BaseRespRepVo {
    private String errmsg;
    private int errno;

    @Override
    public String toString() {
        return "BaseRespRepVo{" +
                "errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public BaseRespRepVo(String errmsg, int errno) {
        this.errmsg = errmsg;
        this.errno = errno;
    }

    public BaseRespRepVo() {
    }
}
