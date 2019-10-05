package com.cskaoyan.mall.vo.adminvo.voSJB;

public class FeedbackListVo {
    private int errno;
    private DataForFeedbackListVo data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public DataForFeedbackListVo getData() {
        return data;
    }

    public void setData(DataForFeedbackListVo data) {
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
        return "FeedbackListVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public FeedbackListVo(int errno, DataForFeedbackListVo data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public FeedbackListVo() {
    }
}
