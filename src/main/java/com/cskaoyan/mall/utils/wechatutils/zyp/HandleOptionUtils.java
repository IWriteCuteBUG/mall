package com.cskaoyan.mall.utils.wechatutils.zyp;

import com.cskaoyan.mall.vo.wechatvo.zyp.HandleOption;

public class HandleOptionUtils {

    public static HandleOption getHandleOption() {
        HandleOption handleOption = new HandleOption();

//        订单是否完成
        handleOption.setCancel(true);
//

        handleOption.setDelete(false);
        handleOption.setPay(false);
        handleOption.setComment(false);
        handleOption.setConfirm(false);
        handleOption.setRefund(false);
        handleOption.setRebuy(false);
        return handleOption;
    }
}
