package com.cskaoyan.mall.vo.adminvo;

//{
//	"errno": 0,
//	"data": {
//		"goodsTotal": 256,
//		"userTotal": 22,
//		"productTotal": 261,
//		"orderTotal": 207
//	},
//	"errmsg": "成功"
//}
public class DashBoardVo {
    private int errno;
    private DashBoardDataVo dataVo;
    private String errmsg;

    @Override
    public String toString() {
        return "DashBoardVo{" +
                "errno=" + errno +
                ", dataVo=" + dataVo +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public DashBoardDataVo getDataVo() {
        return dataVo;
    }

    public void setDataVo(DashBoardDataVo dataVo) {
        this.dataVo = dataVo;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
