package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/6.
 */

public class Order {

    /**
     * total : 8
     * rows : [{"createtime":"2017-11-06 09:22:29.0","yearmonth":"201710","status":"2","shippingtype":"0","orderdate":"2017-11-06","storageamount":0,"ordernum":"201711060003","salesamount":26518.5,"freightamount":0,"ordertotal":7.47,"period":"01","orderamount":26518.5},{"createtime":"2017-10-28 17:05:15.0","yearmonth":"201709","status":"2","shippingtype":"0","orderdate":"2017-10-28","storageamount":0,"ordernum":"201710280002","salesamount":291200,"freightamount":0,"ordertotal":80,"period":"03","orderamount":291200},{"createtime":"2017-10-28 16:59:59.0","yearmonth":"201709","status":"2","shippingtype":"0","orderdate":"2017-10-28","storageamount":0,"ordernum":"201710280001","salesamount":0,"freightamount":0,"ordertotal":0,"period":"03","orderamount":0},{"createtime":"2017-10-27 08:31:45.0","yearmonth":"201710","status":"2","shippingtype":"0","orderdate":"2017-10-27","storageamount":0,"ordernum":"201710270001","salesamount":11130.32,"freightamount":0,"ordertotal":2.984,"period":"02","orderamount":11130.32},{"createtime":"2017-10-26 16:18:56.0","yearmonth":"201710","status":"2","shippingtype":"0","orderdate":"2017-10-26","storageamount":0,"ordernum":"201710260001","salesamount":11130.32,"freightamount":0,"ordertotal":2.984,"period":"02","orderamount":11130.32},{"createtime":"2017-10-23 16:27:28.0","yearmonth":"201710","status":"1","shippingtype":"0","orderdate":"2017-10-23","storageamount":0,"ordernum":"201710230002","salesamount":451200,"freightamount":0,"ordertotal":120,"period":"03","orderamount":451200},{"createtime":"2017-10-23 14:49:41.0","yearmonth":"201710","status":"2","shippingtype":"0","orderdate":"2017-10-23","storageamount":0,"ordernum":"201710230001","salesamount":44760,"freightamount":0,"ordertotal":12,"period":"03","orderamount":44760},{"createtime":"2017-10-19 13:30:46.0","yearmonth":"201710","status":"8","shippingtype":"0","orderdate":"2017-10-19","storageamount":0,"ordernum":"201710190001","salesamount":106500,"freightamount":0,"ordertotal":30,"period":"02","orderamount":106500}]
     * footer : [{"ordernum":"","orderdate":"合计：","ordertotal":"255.438","orderamount":"942439.14","salesamount":"942439.14","freightamount":"0.00","storageamount":"0.00"}]
     */

    private int total;
    private List<Rows> rows;
    private List<Footer> footer;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }

    public List<Footer> getFooter() {
        return footer;
    }

    public void setFooter(List<Footer> footer) {
        this.footer = footer;
    }

    public static class Rows {
        /**
         * createtime : 2017-11-06 09:22:29.0
         * yearmonth : 201710
         * status : 2
         * shippingtype : 0
         * orderdate : 2017-11-06
         * storageamount : 0
         * ordernum : 201711060003
         * salesamount : 26518.5
         * freightamount : 0
         * ordertotal : 7.47
         * period : 01
         * orderamount : 26518.5
         */
        private String orderid;
        private String createtime;
        private String yearmonth;
        private String status;
        private String shippingtype;
        private String orderdate;
        private int storageamount;
        private String ordernum;
        private double salesamount;
        private int freightamount;
        private double ordertotal;
        private String period;
        private double orderamount;

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getYearmonth() {
            return yearmonth;
        }

        public void setYearmonth(String yearmonth) {
            this.yearmonth = yearmonth;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getShippingtype() {
            return shippingtype;
        }

        public void setShippingtype(String shippingtype) {
            this.shippingtype = shippingtype;
        }

        public String getOrderdate() {
            return orderdate;
        }

        public void setOrderdate(String orderdate) {
            this.orderdate = orderdate;
        }

        public int getStorageamount() {
            return storageamount;
        }

        public void setStorageamount(int storageamount) {
            this.storageamount = storageamount;
        }

        public String getOrdernum() {
            return ordernum;
        }

        public void setOrdernum(String ordernum) {
            this.ordernum = ordernum;
        }

        public double getSalesamount() {
            return salesamount;
        }

        public void setSalesamount(double salesamount) {
            this.salesamount = salesamount;
        }

        public int getFreightamount() {
            return freightamount;
        }

        public void setFreightamount(int freightamount) {
            this.freightamount = freightamount;
        }

        public double getOrdertotal() {
            return ordertotal;
        }

        public void setOrdertotal(double ordertotal) {
            this.ordertotal = ordertotal;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public double getOrderamount() {
            return orderamount;
        }

        public void setOrderamount(double orderamount) {
            this.orderamount = orderamount;
        }
    }

    public static class Footer {
        /**
         * ordernum :
         * orderdate : 合计：
         * ordertotal : 255.438
         * orderamount : 942439.14
         * salesamount : 942439.14
         * freightamount : 0.00
         * storageamount : 0.00
         */

        private String ordernum;
        private String orderdate;
        private String ordertotal;
        private String orderamount;
        private String salesamount;
        private String freightamount;
        private String storageamount;

        public String getOrdernum() {
            return ordernum;
        }

        public void setOrdernum(String ordernum) {
            this.ordernum = ordernum;
        }

        public String getOrderdate() {
            return orderdate;
        }

        public void setOrderdate(String orderdate) {
            this.orderdate = orderdate;
        }

        public String getOrdertotal() {
            return ordertotal;
        }

        public void setOrdertotal(String ordertotal) {
            this.ordertotal = ordertotal;
        }

        public String getOrderamount() {
            return orderamount;
        }

        public void setOrderamount(String orderamount) {
            this.orderamount = orderamount;
        }

        public String getSalesamount() {
            return salesamount;
        }

        public void setSalesamount(String salesamount) {
            this.salesamount = salesamount;
        }

        public String getFreightamount() {
            return freightamount;
        }

        public void setFreightamount(String freightamount) {
            this.freightamount = freightamount;
        }

        public String getStorageamount() {
            return storageamount;
        }

        public void setStorageamount(String storageamount) {
            this.storageamount = storageamount;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
