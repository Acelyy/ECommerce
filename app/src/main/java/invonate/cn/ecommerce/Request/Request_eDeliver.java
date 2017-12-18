package invonate.cn.ecommerce.Request;

/**
 * Created by liyangyang on 2017/12/14.
 */

public class Request_eDeliver {
    private String carnum;
    private String contacts;
    private String modifer;
    private String noticeid;
    private String phonenum;
    private String noticeno; //  发货通知单号
    private String comment;

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getModifer() {
        return modifer;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer;
    }

    public String getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(String noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticeno() {
        return noticeno;
    }

    public void setNoticeno(String noticeno) {
        this.noticeno = noticeno;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
