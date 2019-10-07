package com.cskaoyan.mall.vo.adminvo.voLJW.wxvoLJW;

public class CheckedCarts {
  private    int isChecked;
  private  int[] productIds;

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int[] getProductIds() {
        return productIds;
    }

    public void setProductIds(int[] productIds) {
        this.productIds = productIds;
    }
}
