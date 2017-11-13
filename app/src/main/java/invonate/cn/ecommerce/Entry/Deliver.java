package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/7.
 */

public class Deliver {

    /**
     * footer : [{"noticedate":"合计：","noticetotal":"57.974","realnum":"0.000"}]
     * rows : [{"customernamecn":"杭州鼎钧钢铁有限公司","noticedate":"2017-11-06","noticeid":"7B39C9B5-D47E-4AA5-8711-74E749DBC4CF","noticeno":"S1711060008","status":"0"},{"customernamecn":"杭州鼎钧钢铁有限公司","noticedate":"2017-11-06","noticeid":"0D10A5A6-9B97-42EE-B425-B0C785407454","noticeno":"S1711060007","status":"0"},{"customernamecn":"杭州鼎钧钢铁有限公司","noticedate":"2017-10-28","noticeid":"0193AE17-E398-40FD-B04B-6F7D6270766B","noticeno":"S1710280001","status":"2"},{"customernamecn":"杭州鼎钧钢铁有限公司","noticedate":"2017-10-27","noticeid":"E57286DE-551E-47F5-9D54-453E5D4B1F46","noticeno":"S1710270001","status":"4"},{"customernamecn":"杭州鼎钧钢铁有限公司","noticedate":"2017-10-24","noticeid":"599306B4-2A8D-489B-AF8A-55CD3F68879E","noticeno":"S1710240001","status":"0"}]
     * total : 5
     */

    private int total;
    private List<Footer> footer;
    private List<Rows> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Footer> getFooter() {
        return footer;
    }

    public void setFooter(List<Footer> footer) {
        this.footer = footer;
    }

    public List<Rows> getRows() {
        return rows;
    }

    public void setRows(List<Rows> rows) {
        this.rows = rows;
    }

    public static class Footer {
        /**
         * noticedate : 合计：
         * noticetotal : 57.974
         * realnum : 0.000
         */

        private String noticedate;
        private String noticetotal;
        private String realnum;

        public String getNoticedate() {
            return noticedate;
        }

        public void setNoticedate(String noticedate) {
            this.noticedate = noticedate;
        }

        public String getNoticetotal() {
            return noticetotal;
        }

        public void setNoticetotal(String noticetotal) {
            this.noticetotal = noticetotal;
        }

        public String getRealnum() {
            return realnum;
        }

        public void setRealnum(String realnum) {
            this.realnum = realnum;
        }
    }

    public static class Rows {
        /**
         * customernamecn : 杭州鼎钧钢铁有限公司
         * noticedate : 2017-11-06
         * noticeid : 7B39C9B5-D47E-4AA5-8711-74E749DBC4CF
         * noticeno : S1711060008
         * status : 0
         */

        private String customernamecn;
        private String noticedate;
        private String noticeid;
        private String noticeno;
        private String status;

        public String getCustomernamecn() {
            return customernamecn;
        }

        public void setCustomernamecn(String customernamecn) {
            this.customernamecn = customernamecn;
        }

        public String getNoticedate() {
            return noticedate;
        }

        public void setNoticedate(String noticedate) {
            this.noticedate = noticedate;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
