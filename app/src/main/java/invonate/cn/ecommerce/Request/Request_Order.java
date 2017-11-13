package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/3.
 */

public class Request_Order {
    private String orderdatebegin;// 订单开始时间
    private String orderdateend;// 订单结束时间
    private String ordernum;// 订单号
    private String yearmonth; // 协议量年月
    private String period; // 协议量旬
    private String customerid; // 用户id
    private int page; // 页码
    private int pagesize; //一页条数

    public Request_Order(String orderdatebegin, String orderdateend, String ordernum, String yearmonth, String period, String customerid, int page, int pagesize) {
        this.orderdatebegin = orderdatebegin;
        this.orderdateend = orderdateend;
        this.ordernum = ordernum;
        this.yearmonth = yearmonth;
        this.period = period;
        this.customerid = customerid;
        this.page = page;
        this.pagesize = pagesize;
    }

    public String getOrderdatebegin() {
        return orderdatebegin;
    }

    public void setOrderdatebegin(String orderdatebegin) {
        this.orderdatebegin = orderdatebegin;
    }

    public String getOrderdateend() {
        return orderdateend;
    }

    public void setOrderdateend(String orderdateend) {
        this.orderdateend = orderdateend;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
}
