package invonate.cn.ecommerce.Request;

import java.util.List;

/**
 * Created by liyangyang on 2017/11/20.
 */

public class Request_Shop {
    private String customerid;
    private String yearmonth;
    private String period;
    private String warehousenum;
    private String warehouse;
    private String khofficenum;
    private String khoffice;
    private String officenum;
    private String office;
    private String creater;
    private String iscustorder;

    private List<String> producttypes;
    private List<String> producttype2s;
    private List<String> materials;
    private List<String> specs;
    private List<String> lengths;
    private List<String> plandeliqtys;
    private List<String> singleweights;
    private List<String> nums;
    private List<String> prices;
    private List<String> detailcomments;
    private List<String> resourcedetailids;

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getWarehousenum() {
        return warehousenum;
    }

    public void setWarehousenum(String warehousenum) {
        this.warehousenum = warehousenum;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
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

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getIscustorder() {
        return iscustorder;
    }

    public void setIscustorder(String iscustorder) {
        this.iscustorder = iscustorder;
    }

    public List<String> getProducttypes() {
        return producttypes;
    }

    public void setProducttypes(List<String> producttypes) {
        this.producttypes = producttypes;
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

    public List<String> getResourcedetailids() {
        return resourcedetailids;
    }

    public void setResourcedetailids(List<String> resourcedetailids) {
        this.resourcedetailids = resourcedetailids;
    }
}
