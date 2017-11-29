package invonate.cn.ecommerce.Entry;

/**
 * Created by liyangyang on 2017/11/22.
 */

public class Xun {
    private String id;
    private String name;

    public Xun(String id, String name) {
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
