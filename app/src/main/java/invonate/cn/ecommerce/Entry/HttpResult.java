package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

/**
 * Created by liyangyang on 2017/4/8.
 */

public class HttpResult<T> {
    private int resultCode;
    private String resultMsg;
    private T data;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
