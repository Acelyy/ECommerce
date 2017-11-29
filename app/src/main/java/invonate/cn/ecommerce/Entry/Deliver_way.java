package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

/**
 * Created by liyangyang on 2017/11/29.
 */

public class Deliver_way {
    private String id;
    private String name;

    public Deliver_way(String id, String name) {
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
        return JSON.toJSONString(this);
    }
}
