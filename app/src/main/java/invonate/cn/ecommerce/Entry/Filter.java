package invonate.cn.ecommerce.Entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyangyang on 2017/11/16.
 */

public class Filter {

    private ArrayList<Rows> rows;

    public ArrayList<Rows> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Rows> rows) {
        this.rows = rows;
    }

    public static class Rows implements Serializable{
        /**
         * list : [{"warehouse":"管家漾","warehousenum":"901"},{"warehouse":"仁和港","warehousenum":"902"},{"warehouse":"绍兴库","warehousenum":"908"}]
         * office : 杭州永钢物资有限公司
         * officenum : 11
         */

        private String office;
        private String officenum;
        private List<Cage> list;

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

        public List<Cage> getList() {
            return list;
        }

        public void setList(List<Cage> list) {
            this.list = list;
        }

        @Override
        public String toString() {
            return this.getOffice();
        }

        public static class Cage implements Serializable{
            /**
             * warehouse : 管家漾
             * warehousenum : 901
             */

            private String warehouse;
            private String warehousenum;

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

            @Override
            public String toString() {
                return this.getWarehouse();
            }
        }
    }
}
