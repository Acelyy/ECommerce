package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/7.
 */

public class Request_DeliverDetail {
    private String noticeid;

    public Request_DeliverDetail(String noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(String noticeid) {
        this.noticeid = noticeid;
    }
}
