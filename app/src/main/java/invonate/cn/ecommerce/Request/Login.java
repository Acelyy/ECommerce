package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/11/3.
 */

public class Login {
    private String veryCode;
    private String ownercode;
    private String password;
    private String clientid;
    private String appversion;

    public Login(String veryCode, String ownercode, String password, String clientid, String appversion) {
        this.veryCode = veryCode;
        this.ownercode = ownercode;
        this.password = password;
        this.clientid = clientid;
        this.appversion = appversion;
    }

    public String getVeryCode() {
        return veryCode;
    }

    public void setVeryCode(String veryCode) {
        this.veryCode = veryCode;
    }

    public String getOwnercode() {
        return ownercode;
    }

    public void setOwnercode(String ownercode) {
        this.ownercode = ownercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }
}
