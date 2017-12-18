package invonate.cn.ecommerce.Request;

import java.util.List;

/**
 * Created by liyangyang on 2017/12/13.
 */

public class Request_sDeliver {
    private String carnum; // 车号
    private String contacts; // 联系人
    private String creater; // 用户中文
    private String modifer; // 用户中文
    private String shipnum; // 船号
    private String customerno;
    private String customerid;
    private String customernamecn;
    private String deliveplacecode;
    private String deliveplace; // 交货地点
    private String deliveport; // 到港码头
    private String deliveportnum;
    private String officenum; // 提货办事处
    private String office;
    private String khofficenum; // 客户所属办事处
    private String khoffice;
    private String warehouse; // 提货仓库
    private String warehousenum;
    private String phonenum; // 联系电话
    private String transway; // 运费担当
    private String shippingtype; // 承运方式
    private String period; // 旬
    private String receiveno; // 收货序号
    private String yearmonth; // 协议量年月

    private List<String> noticedetailids;
    private List<String> orderids;
    private List<String> ordernums;
    private List<String> orderdetailids;
    private List<String> producttypecodes;
    private List<String> producttypes;
    private List<String> producttype2codes;
    private List<String> producttype2s;
    private List<String> materials;
    private List<String> specs;
    private List<String> lengths;
    private List<String> plandeliqtys;
    private List<String> singleweights;
    private List<String> nums;
    private List<String> prices;
    private List<String> detailcomments;

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

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getModifer() {
        return modifer;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer;
    }

    public String getShipnum() {
        return shipnum;
    }

    public void setShipnum(String shipnum) {
        this.shipnum = shipnum;
    }

    public String getCustomerno() {
        return customerno;
    }

    public void setCustomerno(String customerno) {
        this.customerno = customerno;
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

    public String getDeliveplacecode() {
        return deliveplacecode;
    }

    public void setDeliveplacecode(String deliveplacecode) {
        this.deliveplacecode = deliveplacecode;
    }

    public String getDeliveplace() {
        return deliveplace;
    }

    public void setDeliveplace(String deliveplace) {
        this.deliveplace = deliveplace;
    }

    public String getDeliveport() {
        return deliveport;
    }

    public void setDeliveport(String deliveport) {
        this.deliveport = deliveport;
    }

    public String getDeliveportnum() {
        return deliveportnum;
    }

    public void setDeliveportnum(String deliveportnum) {
        this.deliveportnum = deliveportnum;
    }

    public String getOfficenum() {
        return officenum;
    }

    public void setOfficenum(String officenum) {
        this.officenum = officenum;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getKhofficenum() {
        return khofficenum;
    }

    public void setKhofficenum(String khofficenum) {
        this.khofficenum = khofficenum;
    }

    public String getKhoffice() {
        return khoffice;
    }

    public void setKhoffice(String khoffice) {
        this.khoffice = khoffice;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehousenum() {
        return warehousenum;
    }

    public void setWarehousenum(String warehousenum) {
        this.warehousenum = warehousenum;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getTransway() {
        return transway;
    }

    public void setTransway(String transway) {
        this.transway = transway;
    }

    public String getShippingtype() {
        return shippingtype;
    }

    public void setShippingtype(String shippingtype) {
        this.shippingtype = shippingtype;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getReceiveno() {
        return receiveno;
    }

    public void setReceiveno(String receiveno) {
        this.receiveno = receiveno;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public List<String> getNoticedetailids() {
        return noticedetailids;
    }

    public void setNoticedetailids(List<String> noticedetailids) {
        this.noticedetailids = noticedetailids;
    }

    public List<String> getOrderids() {
        return orderids;
    }

    public void setOrderids(List<String> orderids) {
        this.orderids = orderids;
    }

    public List<String> getOrdernums() {
        return ordernums;
    }

    public void setOrdernums(List<String> ordernums) {
        this.ordernums = ordernums;
    }

    public List<String> getOrderdetailids() {
        return orderdetailids;
    }

    public void setOrderdetailids(List<String> orderdetailids) {
        this.orderdetailids = orderdetailids;
    }

    public List<String> getProducttypecodes() {
        return producttypecodes;
    }

    public void setProducttypecodes(List<String> producttypecodes) {
        this.producttypecodes = producttypecodes;
    }

    public List<String> getProducttypes() {
        return producttypes;
    }

    public void setProducttypes(List<String> producttypes) {
        this.producttypes = producttypes;
    }

    public List<String> getProducttype2codes() {
        return producttype2codes;
    }

    public void setProducttype2codes(List<String> producttype2codes) {
        this.producttype2codes = producttype2codes;
    }

    public List<String> getProducttype2s() {
        return producttype2s;
    }

    public void setProducttype2s(List<String> producttype2s) {
        this.producttype2s = producttype2s;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public List<String> getSpecs() {
        return specs;
    }

    public void setSpecs(List<String> specs) {
        this.specs = specs;
    }

    public List<String> getLengths() {
        return lengths;
    }

    public void setLengths(List<String> lengths) {
        this.lengths = lengths;
    }

    public List<String> getPlandeliqtys() {
        return plandeliqtys;
    }

    public void setPlandeliqtys(List<String> plandeliqtys) {
        this.plandeliqtys = plandeliqtys;
    }

    public List<String> getSingleweights() {
        return singleweights;
    }

    public void setSingleweights(List<String> singleweights) {
        this.singleweights = singleweights;
    }

    public List<String> getNums() {
        return nums;
    }

    public void setNums(List<String> nums) {
        this.nums = nums;
    }

    public List<String> getPrices() {
        return prices;
    }

    public void setPrices(List<String> prices) {
        this.prices = prices;
    }

    public List<String> getDetailcomments() {
        return detailcomments;
    }

    public void setDetailcomments(List<String> detailcomments) {
        this.detailcomments = detailcomments;
    }
}
