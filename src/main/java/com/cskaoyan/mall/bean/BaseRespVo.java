package com.cskaoyan.mall.bean;

public class BaseRespVo<T> {

    private T data;
    private String errmsg;
    private int errno;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public static BaseRespVo ok(Object s) {
        BaseRespVo baseRespVo = new BaseRespVo<>();
        baseRespVo.setData(s);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }

    public static BaseRespVo info(Object infoVo) {
        BaseRespVo baseRespVo = new BaseRespVo<>();
        baseRespVo.setData(infoVo);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
