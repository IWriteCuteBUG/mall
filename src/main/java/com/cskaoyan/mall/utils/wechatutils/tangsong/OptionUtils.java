package com.cskaoyan.mall.utils.wechatutils.tangsong;

import java.util.HashMap;

public class OptionUtils {
    /*"handleOption":{
        "cancel":false,
                "delete":true,
                "pay":false,
                "comment":false,
                "confirm":false,
                "refund":false,
                "rebuy":false
    }*/
    public boolean cancel;
    public boolean delete;
    public boolean pay;
    public boolean comment;
    public boolean confirm;
    public boolean refund;
    public boolean rebuy;

    public OptionUtils(int status){
        if (status == 101) {
            this.cancel = true;
            this.pay = true;
            this.comment = false;
            this.delete = false;
            this.confirm = false;
            this.refund = false;
            this.rebuy = false;
        } else if (status == 103) {
            this.cancel=false;
            this.delete=true;
            this.pay=false;
            this.comment=false;
            this.confirm=false;
            this.refund=false;
            this.rebuy=false;
        } else if (status == 102 || status == 203) {
            this.cancel=false;
            this.delete=true;
            this.pay=false;
            this.comment=false;
            this.confirm=false;
            this.refund=false;
            this.rebuy=false;
        } else if (status == 402) {
            this.cancel=false;
            this.delete=true;
            this.pay=false;
            this.comment=true;
            this.confirm=false;
            this.refund=false;
            this.rebuy=true;
        } else if (status == 202) {
            this.cancel=false;
            this.delete=false;
            this.pay=false;
            this.comment=false;
            this.confirm=false;
            this.refund=false;
            this.rebuy=false;
        } else if (status == 401) {
            this.cancel=false;
            this.delete=true;
            this.pay=false;
            this.comment=true;
            this.confirm=false;
            this.refund=false;
            this.rebuy=true;
        } else if (status == 201) {
            this.cancel=false;
            this.delete=false;
            this.pay=false;
            this.comment=false;
            this.confirm=true;
            this.refund=false;
            this.rebuy=true;
        } else if (status == 301) {
            this.cancel=false;
            this.delete=false;
            this.pay=false;
            this.comment=false;
            this.confirm=true;
            this.refund=false;
            this.rebuy=true;
        }

    }

}
