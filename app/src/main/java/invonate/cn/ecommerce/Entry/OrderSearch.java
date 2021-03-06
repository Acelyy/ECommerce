package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by liyangyang on 2017/11/29.
 */

public class OrderSearch {

    /**
     * rows : [{"detailcomment":"","detailnoticenum":0,"khoffice":"杭州永钢物资有限公司","khofficenum":"11","length":"9000","material":"HRB400E","num":44.85,"office":"销售处综合科","officenum":"00","orderdetailid":"D9D3A078-35E5-4B2C-A665-0D52C2530F20","orderid":"A01F8F04-5E14-4216-B7D4-FE6CACDAEB6D","ordernum":"201711230003","period":"01","plandeliqty":30,"price":3550,"producttype":"建材","producttype2":"螺纹钢","producttype2code":"01","producttypecode":"A","ptdetailnoticenum":0,"ptremainDetailnoticenum":44.85,"remainDetailnoticenum":44.85,"shippingtype":"0","singleweight":1.495,"spec":"120","warehouse":"江苏永钢","warehousenum":"000","yearmonth":"201711"},{"detailcomment":"","detailnoticenum":0,"khoffice":"杭州永钢物资有限公司","khofficenum":"11","length":"9000","material":"HRB400E","num":29.9,"office":"销售处综合科","officenum":"00","orderdetailid":"0D420794-CB4B-4B7A-95ED-B798101AFEFF","orderid":"DE39F31B-38C9-4F85-841B-C71053CAE9E4","ordernum":"201711230002","period":"01","plandeliqty":20,"price":3550,"producttype":"建材","producttype2":"螺纹钢","producttype2code":"01","producttypecode":"A","ptdetailnoticenum":29.9,"ptremainDetailnoticenum":0,"remainDetailnoticenum":29.9,"shippingtype":"0","singleweight":1.495,"spec":"120","warehouse":"江苏永钢","warehousenum":"000","yearmonth":"201711"}]
     * total : 2
     */

    private int total;
    private ArrayList<Rows> rows;
    private ArrayList<Trans> lrows;
    private ArrayList<Trans> trows;
    private ArrayList<Trans> wrows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Rows> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Rows> rows) {
        this.rows = rows;
    }

    public ArrayList<Trans> getLrows() {
        return lrows;
    }

    public void setLrows(ArrayList<Trans> lrows) {
        this.lrows = lrows;
    }

    public ArrayList<Trans> getTrows() {
        return trows;
    }

    public void setTrows(ArrayList<Trans> trows) {
        this.trows = trows;
    }

    public ArrayList<Trans> getWrows() {
        return wrows;
    }

    public void setWrows(ArrayList<Trans> wrows) {
        this.wrows = wrows;
    }

    public static class Rows implements Serializable {
        /**
         * detailcomment :
         * detailnoticenum : 0.0
         * khoffice : 杭州永钢物资有限公司
         * khofficenum : 11
         * length : 9000
         * material : HRB400E
         * num : 44.85
         * office : 销售处综合科
         * officenum : 00
         * orderdetailid : D9D3A078-35E5-4B2C-A665-0D52C2530F20
         * orderid : A01F8F04-5E14-4216-B7D4-FE6CACDAEB6D
         * ordernum : 201711230003
         * period : 01
         * plandeliqty : 30
         * price : 3550.0
         * producttype : 建材
         * producttype2 : 螺纹钢
         * producttype2code : 01
         * producttypecode : A
         * ptdetailnoticenum : 0.0
         * ptremainDetailnoticenum : 44.85
         * remainDetailnoticenum : 44.85
         * shippingtype : 0
         * singleweight : 1.495
         * spec : 120
         * warehouse : 江苏永钢
         * warehousenum : 000
         * yearmonth : 201711
         */

        private String detailcomment;
        private double detailnoticenum;
        private String khoffice;
        private String khofficenum;
        private String length;
        private String material;
        private String num;
        private String office;
        private String officenum;
        private String orderdetailid;
        private String orderid;
        private String ordernum;
        private String period;
        private int plandeliqty;
        private String price;
        private String producttype;
        private String producttype2;
        private String producttype2code;
        private String producttypecode;
        private String ptdetailnoticenum;
        private String ptremainDetailnoticenum;
        private String remainDetailnoticenum;
        private String shippingtype;
        private String singleweight;
        private String spec;
        private String warehouse;
        private String warehousenum;
        private String yearmonth;

        private String point; // 实际下单件数，初值为最大下单件数
        private int maxPoint; // 最大下单件数
        private String orderWgt; //下单重量




        public String getDetailcomment() {
            return detailcomment;
        }

        public void setDetailcomment(String detailcomment) {
            this.detailcomment = detailcomment;
        }

        public double getDetailnoticenum() {
            return detailnoticenum;
        }

        public void setDetailnoticenum(double detailnoticenum) {
            this.detailnoticenum = detailnoticenum;
        }

        public String getKhoffice() {
            return khoffice;
        }

        public void setKhoffice(String khoffice) {
            this.khoffice = khoffice;
        }

        public String getKhofficenum() {
            return khofficenum;
        }

        public void setKhofficenum(String khofficenum) {
            this.khofficenum = khofficenum;
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

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getOffice() {
            return office;
        }

        public void setOffice(String office) {
            this.office = office;
        }

        public String getOfficenum() {
            return officenum;
        }

        public void setOfficenum(String officenum) {
            this.officenum = officenum;
        }

        public String getOrderdetailid() {
            return orderdetailid;
        }

        public void setOrderdetailid(String orderdetailid) {
            this.orderdetailid = orderdetailid;
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

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }

        public int getPlandeliqty() {
            return plandeliqty;
        }

        public void setPlandeliqty(int plandeliqty) {
            this.plandeliqty = plandeliqty;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
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

        public String getProducttype2code() {
            return producttype2code;
        }

        public void setProducttype2code(String producttype2code) {
            this.producttype2code = producttype2code;
        }

        public String getProducttypecode() {
            return producttypecode;
        }

        public void setProducttypecode(String producttypecode) {
            this.producttypecode = producttypecode;
        }

        public String getPtdetailnoticenum() {
            return ptdetailnoticenum;
        }

        public void setPtdetailnoticenum(String ptdetailnoticenum) {
            this.ptdetailnoticenum = ptdetailnoticenum;
        }

        public String getPtremainDetailnoticenum() {
            return ptremainDetailnoticenum;
        }

        public void setPtremainDetailnoticenum(String ptremainDetailnoticenum) {
            this.ptremainDetailnoticenum = ptremainDetailnoticenum;
        }

        public String getRemainDetailnoticenum() {
            return remainDetailnoticenum;
        }

        public void setRemainDetailnoticenum(String remainDetailnoticenum) {
            this.remainDetailnoticenum = remainDetailnoticenum;
        }

        public String getShippingtype() {
            return shippingtype;
        }

        public void setShippingtype(String shippingtype) {
            this.shippingtype = shippingtype;
        }

        public String getSingleweight() {
            return singleweight;
        }

        public void setSingleweight(String singleweight) {
            this.singleweight = singleweight;
        }

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public String getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(String warehouse) {
            this.warehouse = warehouse;
        }

        public String getWarehousenum() {
            return warehousenum;
        }

        public void setWarehousenum(String warehousenum) {
            this.warehousenum = warehousenum;
        }

        public String getYearmonth() {
            return yearmonth;
        }

        public void setYearmonth(String yearmonth) {
            this.yearmonth = yearmonth;
        }


        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public int getMaxPoint() {
            return maxPoint;
        }

        public void setMaxPoint() {
            BigDecimal bd = new BigDecimal(getNum());
            this.maxPoint = bd.divide(new BigDecimal(getSingleweight()), 0).intValue();
            if (point == null) {
                setPoint(this.maxPoint + "");
            }

        }

        public String getOrderWgt() {
            return orderWgt;
        }

        public void setOrderWgt(String orderWgt) {
            this.orderWgt = orderWgt;
        }



    }

    public static class Trans implements Serializable{
        private String custno;
        private String locationno;
        private String recname;
        private String recorderno;
        private String recshortname;
        private String transportway;
        private String transportwayno;

        public String getCustno() {
            return custno;
        }

        public void setCustno(String custno) {
            this.custno = custno;
        }

        public String getLocationno() {
            return locationno;
        }

        public void setLocationno(String locationno) {
            this.locationno = locationno;
        }

        public String getRecname() {
            return recname;
        }

        public void setRecname(String recname) {
            this.recname = recname;
        }

        public String getRecorderno() {
            return recorderno;
        }

        public void setRecorderno(String recorderno) {
            this.recorderno = recorderno;
        }

        public String getRecshortname() {
            return recshortname;
        }

        public void setRecshortname(String recshortname) {
            this.recshortname = recshortname;
        }

        public String getTransportway() {
            return transportway;
        }

        public void setTransportway(String transportway) {
            this.transportway = transportway;
        }

        public String getTransportwayno() {
            return transportwayno;
        }

        public void setTransportwayno(String transportwayno) {
            this.transportwayno = transportwayno;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
