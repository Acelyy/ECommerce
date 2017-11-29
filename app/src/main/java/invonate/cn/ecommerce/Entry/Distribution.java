package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by liyangyang on 2017/11/17.
 */

public class Distribution {

    /**
     * rows : [{"custdistribId":"B318A0AF-AAB3-4602-8B04-25383BC1265F","length":"9000","material":"HRB400","num":0,"price":"3550.00","producttype":"建材","producttype2":"螺纹钢","producttype2code":"01","producttypecode":"A","spec":"120","totalWgt":120},{"custdistribId":"3050D1D4-7BEC-4592-96D3-23D84BC32F1F","length":"9000","material":"HRB400","num":0,"price":"3550.00","producttype":"建材","producttype2":"螺纹钢","producttype2code":"01","producttypecode":"A","spec":"160","totalWgt":120}]
     * total : 2
     */

    private int total;
    private List<Rows> rows;

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

    public static class Rows implements Serializable {

        /**
         * custdistribId : B318A0AF-AAB3-4602-8B04-25383BC1265F
         * length : 9000
         * material : HRB400
         * num : 0.0
         * price : 3550.00
         * producttype : 建材
         * producttype2 : 螺纹钢
         * producttype2code : 01
         * producttypecode : A
         * spec : 120
         * totalWgt : 120.0
         */

        private String custdistribId;
        private String length;
        private String material;
        private String num;
        private String price;
        private String producttype;
        private String producttype2;
        private String producttype2code;
        private String producttypecode;
        private String spec;
        private String totalWgt;
        private String Singleweight;
        private boolean select;
        private String point; // 实际下单件数，初值为最大下单件数
        private int maxPoint; // 最大下单件数
        private String orderWgt; //下单重量
        private String orderdetailid;
        private String orderid;

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

        public String getCustdistribId() {
            return custdistribId;
        }

        public void setCustdistribId(String custdistribId) {
            this.custdistribId = custdistribId;
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

        public String getSpec() {
            return spec;
        }

        public void setSpec(String spec) {
            this.spec = spec;
        }

        public String getTotalWgt() {
            return totalWgt;
        }

        public void setTotalWgt(String totalWgt) {
            this.totalWgt = totalWgt;
        }

        public String getSingleweight() {
            return Singleweight;
        }

        public void setSingleweight(String singleweight) {
            Singleweight = singleweight;
        }

        public boolean isSelect() {
            return select;
        }

        public void setSelect(boolean select) {
            this.select = select;
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
            BigDecimal bd = new BigDecimal(getSumMax());
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

        /**
         * 获取最大下单吨量
         *
         * @return
         */
        public String getSumMax() {
            BigDecimal bd1 = new BigDecimal(getTotalWgt());
            BigDecimal bd2 = new BigDecimal(getNum());
            return bd1.subtract(bd2).setScale(3, BigDecimal.ROUND_DOWN).toString();
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
