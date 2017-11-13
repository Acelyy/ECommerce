package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/6.
 */

public class OrderDetail {

    /**
     * kkdetailList : [{"accountnum":"04536","amount":26518.5,"createtime":"2017-11-06 09:22:33","office":"杭州永钢物资有限公司","purposes":"强制订单扣款"}]
     * orderdetailList : [{"amount":26518.5,"length":"9000","material":"HRB400","num":7.47,"plandeliqty":5,"price":3550,"producttype":"建材","producttype2":"螺纹钢","singleweight":1.494,"spec":"180"}]
     * resource : {"createtime":"2017-11-06 09:22:29","freightamount":0,"orderamount":26518.5,"orderdate":"2017-11-06","orderid":"17B32E20-3A01-47F9-A046-3C40ECCF7E97","ordernum":"201711060003","ordertotal":7.47,"period":"01","salesamount":26518.5,"shippingtype":"0","status":"2","storageamount":0,"yearmonth":"201710"}
     */

    private Resource resource;
    private List<KkdetailList> kkdetailList;
    private List<OrderdetailList> orderdetailList;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public List<KkdetailList> getKkdetailList() {
        return kkdetailList;
    }

    public void setKkdetailList(List<KkdetailList> kkdetailList) {
        this.kkdetailList = kkdetailList;
    }

    public List<OrderdetailList> getOrderdetailList() {
        return orderdetailList;
    }

    public void setOrderdetailList(List<OrderdetailList> orderdetailList) {
        this.orderdetailList = orderdetailList;
    }

    public static class Resource {
        /**
         * createtime : 2017-11-06 09:22:29
         * freightamount : 0
         * orderamount : 26518.5
         * orderdate : 2017-11-06
         * orderid : 17B32E20-3A01-47F9-A046-3C40ECCF7E97
         * ordernum : 201711060003
         * ordertotal : 7.47
         * period : 01
         * salesamount : 26518.5
         * shippingtype : 0
         * status : 2
         * storageamount : 0
         * yearmonth : 201710
         */

        private String createtime;
        private int freightamount;
        private double orderamount;
        private String orderdate;
        private String orderid;
        private String ordernum;
        private double ordertotal;
        private String period;
        private double salesamount;
        private String shippingtype;
        private String status;
        private int storageamount;
        private String yearmonth;
        private String customernamecn;
        private String warehouse;
        private String office;
        private String deliveport;
        private String carnum;
        private String contacts;
        private String phonenum;
        private String deliveplace;
        private String comment;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getFreightamount() {
            return freightamount;
        }

        public void setFreightamount(int freightamount) {
            this.freightamount = freightamount;
        }

        public double getOrderamount() {
            return orderamount;
        }

        public void setOrderamount(double orderamount) {
            this.orderamount = orderamount;
        }

        public String getOrderdate() {
            return orderdate;
        }

        public void setOrderdate(String orderdate) {
            this.orderdate = orderdate;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getOrdernum() {
            return ordernum;
        }

        public void setOrdernum(String ordernum) {
            this.ordernum = ordernum;
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

        public double getSalesamount() {
            return salesamount;
        }

        public void setSalesamount(double salesamount) {
            this.salesamount = salesamount;
        }

        public String getShippingtype() {
            return shippingtype;
        }

        public void setShippingtype(String shippingtype) {
            this.shippingtype = shippingtype;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getStorageamount() {
            return storageamount;
        }

        public void setStorageamount(int storageamount) {
            this.storageamount = storageamount;
        }

        public String getYearmonth() {
            return yearmonth;
        }

        public void setYearmonth(String yearmonth) {
            this.yearmonth = yearmonth;
        }

        public String getCustomernamecn() {
            return customernamecn;
        }

        public void setCustomernamecn(String customernamecn) {
            this.customernamecn = customernamecn;
        }

        public String getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(String warehouse) {
            this.warehouse = warehouse;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public String getDeliveport() {
            return deliveport;
        }

        public void setDeliveport(String deliveport) {
            this.deliveport = deliveport;
        }

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

        public String getPhonenum() {
            return phonenum;
        }

        public void setPhonenum(String phonenum) {
            this.phonenum = phonenum;
        }

        public String getDeliveplace() {
            return deliveplace;
        }

        public void setDeliveplace(String deliveplace) {
            this.deliveplace = deliveplace;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

    public static class KkdetailList {
        /**
         * accountnum : 04536
         * amount : 26518.5
         * createtime : 2017-11-06 09:22:33
         * office : 杭州永钢物资有限公司
         * purposes : 强制订单扣款
         */

        private String accountnum;
        private double amount;
        private String createtime;
        private String office;
        private String purposes;

        public String getAccountnum() {
            return accountnum;
        }

        public void setAccountnum(String accountnum) {
            this.accountnum = accountnum;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public String getPurposes() {
            return purposes;
        }

        public void setPurposes(String purposes) {
            this.purposes = purposes;
        }
    }

    public static class OrderdetailList {
        /**
         * amount : 26518.5
         * length : 9000
         * material : HRB400
         * num : 7.47
         * plandeliqty : 5
         * price : 3550
         * producttype : 建材
         * producttype2 : 螺纹钢
         * singleweight : 1.494
         * spec : 180
         */

        private double amount;
        private String length;
        private String material;
        private double num;
        private int plandeliqty;
        private int price;
        private String producttype;
        private String producttype2;
        private double singleweight;
        private String spec;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public double getNum() {
            return num;
        }

        public void setNum(double num) {
            this.num = num;
        }

        public int getPlandeliqty() {
            return plandeliqty;
        }

        public void setPlandeliqty(int plandeliqty) {
            this.plandeliqty = plandeliqty;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getProducttype() {
            return producttype;
        }

        public void setProducttype(String producttype) {
            this.producttype = producttype;
        }

        public String getProducttype2() {
            return producttype2;
        }

        public void setProducttype2(String producttype2) {
            this.producttype2 = producttype2;
        }

        public double getSingleweight() {
            return singleweight;
        }

        public void setSingleweight(double singleweight) {
            this.singleweight = singleweight;
        }

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
