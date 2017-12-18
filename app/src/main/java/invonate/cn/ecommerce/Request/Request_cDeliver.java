package invonate.cn.ecommerce.Request;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/30.
 */

public class Request_cDeliver {
    private String custno;
    private List<String> ordernum;

    public Request_cDeliver(String custno, List<String> ordernum) {
        this.custno = custno;
        this.ordernum = ordernum;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno;
    }

    public List<String> getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(List<String> ordernum) {
        this.ordernum = ordernum;
    }
}
