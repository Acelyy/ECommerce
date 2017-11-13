package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/7.
 */

public class DeliverDetail {

    /**
     * notice : {"carnum":"苏EH1234","contacts":"aaa","createtime":"2017-10-28 17:09:58.0","customernamecn":"杭州鼎钧钢铁有限公司","deliveport":"杭州塘栖天地码头","khoffice":"杭州永钢物资有限公司","noticeid":"0193AE17-E398-40FD-B04B-6F7D6270766B","noticeno":"S1710280001","office":"销售处综合科","period":"下旬","phonenum":"18962298765","shipnum":"","shippingtype":"汽运","transway":"客户自提","warehouse":"江苏永钢","yearmonth":"201709"}
     * noticeDetailList : [{"detailcomment":"","length":"12000","material":"HRB400","num":40,"ordernum":"201710280002","producttype":"建材","producttype2":"螺纹钢","spec":"180"}]
     */

    private Notice notice;
    private List<OrderDetail.OrderdetailList> noticeDetailList;

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public List<OrderDetail.OrderdetailList> getNoticeDetailList() {
        return noticeDetailList;
    }

    public void setNoticeDetailList(List<OrderDetail.OrderdetailList> noticeDetailList) {
        this.noticeDetailList = noticeDetailList;
    }

    public static class Notice {
        /**
         * carnum : 苏EH1234
         * contacts : aaa
         * createtime : 2017-10-28 17:09:58.0
         * customernamecn : 杭州鼎钧钢铁有限公司
         * deliveport : 杭州塘栖天地码头
         * khoffice : 杭州永钢物资有限公司
         * noticeid : 0193AE17-E398-40FD-B04B-6F7D6270766B
         * noticeno : S1710280001
         * office : 销售处综合科
         * period : 下旬
         * phonenum : 18962298765
         * shipnum :
         * shippingtype : 汽运
         * transway : 客户自提
         * warehouse : 江苏永钢
         * yearmonth : 201709
         */

        private String carnum;
        private String contacts;
        private String createtime;
        private String customernamecn;
        private String deliveport;
        private String khoffice;
        private String noticeid;
        private String noticeno;
        private String office;
        private String period;
        private String phonenum;
        private String shipnum;
        private String shippingtype;
        private String transway;
        private String warehouse;
        private String yearmonth;

        public String getCarnum() {
            return carnum;
        }

        public void setCarnum(String carnum) {
            this.carnum = carnum;
        }

        public String getContacts() {
            return contacts;
        }

        public void setContacts(String contacts) {
            this.contacts = contacts;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getCustomernamecn() {
            return customernamecn;
        }

        public void setCustomernamecn(String customernamecn) {
            this.customernamecn = customernamecn;
        }

        public String getDeliveport() {
            return deliveport;
        }

        public void setDeliveport(String deliveport) {
            this.deliveport = deliveport;
        }

        public String getKhoffice() {
            return khoffice;
        }

        public void setKhoffice(String khoffice) {
            this.khoffice = khoffice;
        }

        public String getNoticeid() {
            return noticeid;
        }

        public void setNoticeid(String noticeid) {
            this.noticeid = noticeid;
        }

        public String getNoticeno() {
            return noticeno;
        }

        public void setNoticeno(String noticeno) {
            this.noticeno = noticeno;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public String getPhonenum() {
            return phonenum;
        }

        public void setPhonenum(String phonenum) {
            this.phonenum = phonenum;
        }

        public String getShipnum() {
            return shipnum;
        }

        public void setShipnum(String shipnum) {
            this.shipnum = shipnum;
        }

        public String getShippingtype() {
            return shippingtype;
        }

        public void setShippingtype(String shippingtype) {
            this.shippingtype = shippingtype;
        }

        public String getTransway() {
            return transway;
        }

        public void setTransway(String transway) {
            this.transway = transway;
        }

        public String getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(String warehouse) {
            this.warehouse = warehouse;
        }

        public String getYearmonth() {
            return yearmonth;
        }

        public void setYearmonth(String yearmonth) {
            this.yearmonth = yearmonth;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
