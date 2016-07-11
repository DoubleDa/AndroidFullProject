package cn.wochu.wh.entity.search;

import java.util.List;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/21 下午4:10
 * alter person：dayongxin
 * alter time：16/6/21 下午4:10
 * alter remark：
 */
public class ThridOrderSearchEntity {

    /**
     * ORDERID : 5
     * ORDERCODE : B938130
     * SUMPRICE : 120.33
     * GOODSNUMBER : 9
     * STATUS : 1
     * OPRNO : sa
     * CREATEDATE : 2016-07-01T16:46:28
     * DCJDORDERDETAILItem : [{"ORDERDETAILID":1,"ORDERID":5,"GOODSCODE":"WOC000002744","GOODSNAME":"牛叉","GOODSNUMBER":2,"PRICE":20,"STATUS":"1","OPRNO":"sa","CREATEDATE":"2016-06-28T15:00:00"},{"ORDERDETAILID":2,"ORDERID":5,"GOODSCODE":"WOC000396","GOODSNAME":"肉末蒸娃娃菜","GOODSNUMBER":2,"PRICE":15,"STATUS":"1","OPRNO":"sa","CREATEDATE":"2016-06-28T15:00:00"},{"ORDERDETAILID":3,"ORDERID":5,"GOODSCODE":"WOC000002895","GOODSNAME":"清美老豆腐320g","GOODSNUMBER":6,"PRICE":6.58,"STATUS":"1","OPRNO":"sa","CREATEDATE":"2016-06-28T15:00:00"}]
     */

    private int ORDERID;
    private String ORDERCODE;
    private double SUMPRICE;
    private int GOODSNUMBER;
    private String STATUS;
    private String OPRNO;
    private String CREATEDATE;
    /**
     * ORDERDETAILID : 1
     * ORDERID : 5
     * GOODSCODE : WOC000002744
     * GOODSNAME : 牛叉
     * GOODSNUMBER : 2
     * PRICE : 20
     * STATUS : 1
     * OPRNO : sa
     * CREATEDATE : 2016-06-28T15:00:00
     */

    private List<DCJDORDERDETAILItemEntity> DCJDORDERDETAILItem;

    public int getORDERID() {
        return ORDERID;
    }

    public void setORDERID(int ORDERID) {
        this.ORDERID = ORDERID;
    }

    public String getORDERCODE() {
        return ORDERCODE;
    }

    public void setORDERCODE(String ORDERCODE) {
        this.ORDERCODE = ORDERCODE;
    }

    public double getSUMPRICE() {
        return SUMPRICE;
    }

    public void setSUMPRICE(double SUMPRICE) {
        this.SUMPRICE = SUMPRICE;
    }

    public int getGOODSNUMBER() {
        return GOODSNUMBER;
    }

    public void setGOODSNUMBER(int GOODSNUMBER) {
        this.GOODSNUMBER = GOODSNUMBER;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getOPRNO() {
        return OPRNO;
    }

    public void setOPRNO(String OPRNO) {
        this.OPRNO = OPRNO;
    }

    public String getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public List<DCJDORDERDETAILItemEntity> getDCJDORDERDETAILItem() {
        return DCJDORDERDETAILItem;
    }

    public void setDCJDORDERDETAILItem(List<DCJDORDERDETAILItemEntity> DCJDORDERDETAILItem) {
        this.DCJDORDERDETAILItem = DCJDORDERDETAILItem;
    }

    public static class DCJDORDERDETAILItemEntity {
        private int ORDERDETAILID;
        private int ORDERID;
        private String GOODSCODE;
        private String GOODSNAME;
        private int GOODSNUMBER;
        private double PRICE;
        private String STATUS;
        private String OPRNO;
        private String CREATEDATE;

        public int getORDERDETAILID() {
            return ORDERDETAILID;
        }

        public void setORDERDETAILID(int ORDERDETAILID) {
            this.ORDERDETAILID = ORDERDETAILID;
        }

        public int getORDERID() {
            return ORDERID;
        }

        public void setORDERID(int ORDERID) {
            this.ORDERID = ORDERID;
        }

        public String getGOODSCODE() {
            return GOODSCODE;
        }

        public void setGOODSCODE(String GOODSCODE) {
            this.GOODSCODE = GOODSCODE;
        }

        public String getGOODSNAME() {
            return GOODSNAME;
        }

        public void setGOODSNAME(String GOODSNAME) {
            this.GOODSNAME = GOODSNAME;
        }

        public int getGOODSNUMBER() {
            return GOODSNUMBER;
        }

        public void setGOODSNUMBER(int GOODSNUMBER) {
            this.GOODSNUMBER = GOODSNUMBER;
        }

        public double getPRICE() {
            return PRICE;
        }

        public void setPRICE(int PRICE) {
            this.PRICE = PRICE;
        }

        public String getSTATUS() {
            return STATUS;
        }

        public void setSTATUS(String STATUS) {
            this.STATUS = STATUS;
        }

        public String getOPRNO() {
            return OPRNO;
        }

        public void setOPRNO(String OPRNO) {
            this.OPRNO = OPRNO;
        }

        public String getCREATEDATE() {
            return CREATEDATE;
        }

        public void setCREATEDATE(String CREATEDATE) {
            this.CREATEDATE = CREATEDATE;
        }
    }
}
