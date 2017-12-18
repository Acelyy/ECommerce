package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

/**
 * Created by liyangyang on 2017/12/14.
 */

public class Version {

    /**
     * versionId : 1.2
     * versionPath : /esales/mp3/message.mp3
     */

    private String versionId;
    private String versionPath;

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getVersionPath() {
        return versionPath;
    }

    public void setVersionPath(String versionPath) {
        this.versionPath = versionPath;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
