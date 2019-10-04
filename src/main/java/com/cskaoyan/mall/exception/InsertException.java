package com.cskaoyan.mall.exception;

public class InsertException extends Exception {
    private String customMsg;

    public InsertException(String message, String customMsg) {
        super(message);
        this.customMsg = customMsg;
    }

    public String getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(String customMsg) {
        this.customMsg = customMsg;
    }
}
