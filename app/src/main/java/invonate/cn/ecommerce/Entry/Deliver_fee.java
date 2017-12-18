package invonate.cn.ecommerce.Entry;

/**
 * Created by liyangyang on 2017/12/13.
 */

public class Deliver_fee {
    String id;
    String name;

    public Deliver_fee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
