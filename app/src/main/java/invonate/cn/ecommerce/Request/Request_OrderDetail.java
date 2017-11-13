package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/6.
 */

public class Request_OrderDetail {
    private String orderid;

    public Request_OrderDetail(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
