package invonate.cn.ecommerce.Request;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/29.
 */

public class Request_cOrder {
    private List<String> ordernums;

    public Request_cOrder(List<String> ordernums) {
        this.ordernums = ordernums;
    }

    public List<String> getOrdernums() {
        return ordernums;
    }

    public void setOrdernums(List<String> ordernums) {
        this.ordernums = ordernums;
    }

}
