package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/16.
 */

public class Request_Filter {
    private String customerid;

    public Request_Filter(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
}
