package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/15.
 */

public class Request_Agn {
    private String customerid;
    private int page; // 页码
    private int pagesize; //一页条数

    public Request_Agn(String customerid, int page, int pagesize) {
        this.customerid = customerid;
        this.page = page;
        this.pagesize = pagesize;
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

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
}
