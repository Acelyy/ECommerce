package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/9.
 */

public class Request_Account {
    private String customerid;

    public Request_Account(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }
}
