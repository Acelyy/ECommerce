package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/15.
 */

public class Agn {

    /**
     * rows : [{"agmonth":"201711","agreementdd":0,"agreementdremain":5250,"agreementuremain":4621.874,"agreementuu":628.126,"agreementwgtd":5250,"agreementwgtu":5250,"agreementwgtx":4500,"agreementxremain":4500,"agreementxx":0,"ddhrb":0,"ddswr":0,"dremainhrb":3500,"dremainswr":1750,"uremainhrb":3071.874,"uremainswr":1550,"uuhrb":428.126,"uuswr":200,"wgtdhrb":3500,"wgtdswr":1750,"wgtuhrb":3500,"wgtuswr":1750,"wgtxhrb":0,"wgtxswr":0,"xremainhrb":3000,"xremainswr":1500,"xxhrb":0,"xxswr":0}]
     * total : 5
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

    public static class Rows {
        /**
         * agmonth : 201711
         * agreementdd : 0.0
         * agreementdremain : 5250.0
         * agreementuremain : 4621.874
         * agreementuu : 628.126
         * agreementwgtd : 5250.0
         * agreementwgtu : 5250.0
         * agreementwgtx : 4500.0
         * agreementxremain : 4500.0
         * agreementxx : 0.0
         * ddhrb : 0.0
         * ddswr : 0.0
         * dremainhrb : 3500.0
         * dremainswr : 1750.0
         * uremainhrb : 3071.874
         * uremainswr : 1550.0
         * uuhrb : 428.126
         * uuswr : 200.0
         * wgtdhrb : 3500.0
         * wgtdswr : 1750.0
         * wgtuhrb : 3500.0
         * wgtuswr : 1750.0
         * wgtxhrb : 0.0
         * wgtxswr : 0.0
         * xremainhrb : 3000.0
         * xremainswr : 1500.0
         * xxhrb : 0.0
         * xxswr : 0.0
         */

        private String agmonth;
        private String agreementdd;
        private String agreementdremain;
        private String agreementuremain;
        private String agreementuu;
        private String agreementwgtd;
        private String agreementwgtu;
        private String agreementwgtx;
        private String agreementxremain;
        private String agreementxx;
        private String ddhrb;
        private String ddswr;
        private String dremainhrb;
        private String dremainswr;
        private String uremainhrb;
        private String uremainswr;
        private String uuhrb;
        private String uuswr;
        private String wgtdhrb;
        private String wgtdswr;
        private String wgtuhrb;
        private String wgtuswr;
        private String wgtxhrb;
        private String wgtxswr;
        private String xremainhrb;
        private String xremainswr;
        private String xxhrb;
        private String xxswr;

        public String getAgmonth() {
            return agmonth;
        }

        public void setAgmonth(String agmonth) {
            this.agmonth = agmonth;
        }

        public String getAgreementdd() {
            return agreementdd;
        }

        public void setAgreementdd(String agreementdd) {
            this.agreementdd = agreementdd;
        }

        public String getAgreementdremain() {
            return agreementdremain;
        }

        public void setAgreementdremain(String agreementdremain) {
            this.agreementdremain = agreementdremain;
        }

        public String getAgreementuremain() {
            return agreementuremain;
        }

        public void setAgreementuremain(String agreementuremain) {
            this.agreementuremain = agreementuremain;
        }

        public String getAgreementuu() {
            return agreementuu;
        }

        public void setAgreementuu(String agreementuu) {
            this.agreementuu = agreementuu;
        }

        public String getAgreementwgtd() {
            return agreementwgtd;
        }

        public void setAgreementwgtd(String agreementwgtd) {
            this.agreementwgtd = agreementwgtd;
        }

        public String getAgreementwgtu() {
            return agreementwgtu;
        }

        public void setAgreementwgtu(String agreementwgtu) {
            this.agreementwgtu = agreementwgtu;
        }

        public String getAgreementwgtx() {
            return agreementwgtx;
        }

        public void setAgreementwgtx(String agreementwgtx) {
            this.agreementwgtx = agreementwgtx;
        }

        public String getAgreementxremain() {
            return agreementxremain;
        }

        public void setAgreementxremain(String agreementxremain) {
            this.agreementxremain = agreementxremain;
        }

        public String getAgreementxx() {
            return agreementxx;
        }

        public void setAgreementxx(String agreementxx) {
            this.agreementxx = agreementxx;
        }

        public String getDdhrb() {
            return ddhrb;
        }

        public void setDdhrb(String ddhrb) {
            this.ddhrb = ddhrb;
        }

        public String getDdswr() {
            return ddswr;
        }

        public void setDdswr(String ddswr) {
            this.ddswr = ddswr;
        }

        public String getDremainhrb() {
            return dremainhrb;
        }

        public void setDremainhrb(String dremainhrb) {
            this.dremainhrb = dremainhrb;
        }

        public String getDremainswr() {
            return dremainswr;
        }

        public void setDremainswr(String dremainswr) {
            this.dremainswr = dremainswr;
        }

        public String getUremainhrb() {
            return uremainhrb;
        }

        public void setUremainhrb(String uremainhrb) {
            this.uremainhrb = uremainhrb;
        }

        public String getUremainswr() {
            return uremainswr;
        }

        public void setUremainswr(String uremainswr) {
            this.uremainswr = uremainswr;
        }

        public String getUuhrb() {
            return uuhrb;
        }

        public void setUuhrb(String uuhrb) {
            this.uuhrb = uuhrb;
        }

        public String getUuswr() {
            return uuswr;
        }

        public void setUuswr(String uuswr) {
            this.uuswr = uuswr;
        }

        public String getWgtdhrb() {
            return wgtdhrb;
        }

        public void setWgtdhrb(String wgtdhrb) {
            this.wgtdhrb = wgtdhrb;
        }

        public String getWgtdswr() {
            return wgtdswr;
        }

        public void setWgtdswr(String wgtdswr) {
            this.wgtdswr = wgtdswr;
        }

        public String getWgtuhrb() {
            return wgtuhrb;
        }

        public void setWgtuhrb(String wgtuhrb) {
            this.wgtuhrb = wgtuhrb;
        }

        public String getWgtuswr() {
            return wgtuswr;
        }

        public void setWgtuswr(String wgtuswr) {
            this.wgtuswr = wgtuswr;
        }

        public String getWgtxhrb() {
            return wgtxhrb;
        }

        public void setWgtxhrb(String wgtxhrb) {
            this.wgtxhrb = wgtxhrb;
        }

        public String getWgtxswr() {
            return wgtxswr;
        }

        public void setWgtxswr(String wgtxswr) {
            this.wgtxswr = wgtxswr;
        }

        public String getXremainhrb() {
            return xremainhrb;
        }

        public void setXremainhrb(String xremainhrb) {
            this.xremainhrb = xremainhrb;
        }

        public String getXremainswr() {
            return xremainswr;
        }

        public void setXremainswr(String xremainswr) {
            this.xremainswr = xremainswr;
        }

        public String getXxhrb() {
            return xxhrb;
        }

        public void setXxhrb(String xxhrb) {
            this.xxhrb = xxhrb;
        }

        public String getXxswr() {
            return xxswr;
        }

        public void setXxswr(String xxswr) {
            this.xxswr = xxswr;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
