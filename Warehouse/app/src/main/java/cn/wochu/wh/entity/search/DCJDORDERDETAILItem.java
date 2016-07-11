package cn.wochu.wh.entity.search;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/30 下午1:38
 * alter person：dayongxin
 * alter time：16/6/30 下午1:38
 * alter remark：
 */
public class DCJDORDERDETAILItem {
    private int ORDERDETAILID;

    private int ORDERID;

    private String GOODSCODE;

    private String GOODSNAME;

    private int GOODSNUMBER;

    private int PRICE;

    private String STATUS;

    private String OPRNO;

    private String CREATEDATE;

    public DCJDORDERDETAILItem(String GOODSCODE, String GOODSNAME, int GOODSNUMBER) {
        this.GOODSCODE = GOODSCODE;
        this.GOODSNAME = GOODSNAME;
        this.GOODSNUMBER = GOODSNUMBER;
    }

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

    public int getPRICE() {
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
