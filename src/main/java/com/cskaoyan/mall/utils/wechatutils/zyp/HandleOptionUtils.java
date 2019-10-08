package com.cskaoyan.mall.utils.wechatutils.zyp;

import com.cskaoyan.mall.vo.wechatvo.zyp.HandleOption;

public class HandleOptionUtils {

    public static HandleOption getHandleOption() {
        HandleOption handleOption = new HandleOption();
        handleOption.setCancel(false);
        handleOption.setDelete(false);
        handleOption.setPay(false);
        handleOption.setComment(false);
        handleOption.setConfirm(false);
        handleOption.setRefund(false);
        handleOption.setRebuy(false);
        return handleOption;
    }
}
