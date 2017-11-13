package invonate.cn.ecommerce.httpUtil;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/9.
 */

public class Account {

    /**
     * custinfo : {"customerrationsnum":320,"customerrationsnum2":142.748,"customerrationsnum3":177.252}
     * noticeDetailList : [{"balanceaccount":4794688.816,"customernamecn":"扬州市众成金属材料有限公司"},{"balanceaccount":100000,"customernamecn":"江苏苏美达供应链运营有限公司3"},{"balanceaccount":1.000153111E7,"customernamecn":"扬州市翔泰金属材料有限公司"}]
     */

    private Custinfo custinfo;
    private List<NoticeDetailList> noticeDetailList;

    public Custinfo getCustinfo() {
        return custinfo;
    }

    public void setCustinfo(Custinfo custinfo) {
        this.custinfo = custinfo;
    }

    public List<NoticeDetailList> getNoticeDetailList() {
        return noticeDetailList;
    }

    public void setNoticeDetailList(List<NoticeDetailList> noticeDetailList) {
        this.noticeDetailList = noticeDetailList;
    }

    public static class Custinfo {
        /**
         * customerrationsnum : 320
         * customerrationsnum2 : 142.748
         * customerrationsnum3 : 177.252
         */

        private float customerrationsnum;
        private float customerrationsnum2;
        private float customerrationsnum3;

        public float getCustomerrationsnum() {
            return customerrationsnum;
        }

        public void setCustomerrationsnum(float customerrationsnum) {
            this.customerrationsnum = customerrationsnum;
        }

        public float getCustomerrationsnum2() {
            return customerrationsnum2;
        }

        public void setCustomerrationsnum2(float customerrationsnum2) {
            this.customerrationsnum2 = customerrationsnum2;
        }

        public float getCustomerrationsnum3() {
            return customerrationsnum3;
        }

        public void setCustomerrationsnum3(float customerrationsnum3) {
            this.customerrationsnum3 = customerrationsnum3;
        }
    }

    public static class NoticeDetailList {
        /**
         * balanceaccount : 4794688.816
         * customernamecn : 扬州市众成金属材料有限公司
         */

        private float balanceaccount;
        private String customernamecn;

        public float getBalanceaccount() {
            return balanceaccount;
        }

        public void setBalanceaccount(float balanceaccount) {
            this.balanceaccount = balanceaccount;
        }

        public String getCustomernamecn() {
            return customernamecn;
        }

        public void setCustomernamecn(String customernamecn) {
            this.customernamecn = customernamecn;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
