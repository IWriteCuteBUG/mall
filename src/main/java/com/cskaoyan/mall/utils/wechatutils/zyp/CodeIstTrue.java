package com.cskaoyan.mall.utils.wechatutils.zyp;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.wechatvo.zyp.WeChatRegisterVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class CodeIstTrue {
    public static Boolean verifyCode (WeChatRegisterVo registerVo) {
        int code = registerVo.getCode();
        Session session = SecurityUtils.getSubject().getSession();
        System.out.println(session.getId());
        Integer codeFromSession = (Integer) session.getAttribute("code");
        if (codeFromSession == null) {
            codeFromSession = 0;
        }
        if (code != codeFromSession || code == 0) {
            return false;
        }
        return true;
    }
}
