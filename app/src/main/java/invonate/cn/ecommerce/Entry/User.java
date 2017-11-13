package invonate.cn.ecommerce.Entry;

import com.alibaba.fastjson.JSON;

/**
 * Created by liyangyang on 2017/11/3.
 */

public class User {


    /**
     * accountnum : 04536
     * balanceaccount : 285930572.930
     * consultid : 04536
     * customerid : dc391459-2d42-11e6-85b2-005056ab1806
     * customernamecn : 杭州鼎钧钢铁有限公司
     * customernameen : 杭州鼎钧钢铁有限公司
     * customertype : 1
     * dutynum : 913301056798669187
     * office : 杭州永钢物资有限公司
     * officenum : 11
     * ownercode : 022022
     * phonenum : 15366267993
     * registetime : 2016-06-08 14:33:06
     */

    private String accountnum;
    private String balanceaccount;
    private String consultid;
    private String customerid;
    private String customernamecn;
    private String customernameen;
    private String customertype;
    private String dutynum;
    private String office;
    private String officenum;
    private String ownercode;
    private String phonenum;
    private String registetime;
    private String contacts;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    public String getBalanceaccount() {
        return balanceaccount;
    }

    public void setBalanceaccount(String balanceaccount) {
        this.balanceaccount = balanceaccount;
    }

    public String getConsultid() {
        return consultid;
    }

    public void setConsultid(String consultid) {
        this.consultid = consultid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomernamecn() {
        return customernamecn;
    }

    public void setCustomernamecn(String customernamecn) {
        this.customernamecn = customernamecn;
    }

    public String getCustomernameen() {
        return customernameen;
    }

    public void setCustomernameen(String customernameen) {
        this.customernameen = customernameen;
    }

    public String getCustomertype() {
        return customertype;
    }

    public void setCustomertype(String customertype) {
        this.customertype = customertype;
    }

    public String getDutynum() {
        return dutynum;
    }

    public void setDutynum(String dutynum) {
        this.dutynum = dutynum;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getOfficenum() {
        return officenum;
    }

    public void setOfficenum(String officenum) {
        this.officenum = officenum;
    }

    public String getOwnercode() {
        return ownercode;
    }

    public void setOwnercode(String ownercode) {
        this.ownercode = ownercode;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getRegistetime() {
        return registetime;
    }

    public void setRegistetime(String registetime) {
        this.registetime = registetime;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
