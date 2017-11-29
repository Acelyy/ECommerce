package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/17.
 */

public class Request_Distribution {
    private String accountnum;
    private String warehousenum;

    public Request_Distribution(String accountnum, String warehousenum) {
        this.accountnum = accountnum;
        this.warehousenum = warehousenum;
    }

    public String getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    public String getWarehousenum() {
        return warehousenum;
    }

    public void setWarehousenum(String warehousenum) {
        this.warehousenum = warehousenum;
    }
}
