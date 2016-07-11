package cn.wochu.wh.entity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/16 下午4:09
 * alter person：dayongxin
 * alter time：16/6/16 下午4:09
 * alter remark：
 */
public class GetDCTransOnShelvesEntity {
    public GetDCTransOnShelvesEntity(String GOODSCODE, String GOODSNAME, int GOODSNUMBER, int REQUESTWAREHOUSEID) {
        this.GOODSCODE = GOODSCODE;
        this.GOODSNAME = GOODSNAME;
        this.GOODSNUMBER = GOODSNUMBER;
        this.REQUESTWAREHOUSEID = REQUESTWAREHOUSEID;
    }

    /**
     * INVENTORYMOVEID : 65
     * INVENTORYMOVECODE : WOC00000068178
     * GOODSID : 2282
     * GOODSCODE : WOC000000681
     * GOODSNAME : 北大荒有机米2.5kg
     * REQUESTWAREHOUSEID : 7
     * REQUESTWAREHOUSECODE : QT01
     * REQUESTWAREHOUSENAME : 青浦1号仓库
     * TARGETWAREHOUSEID : 8
     * TARGETWAREHOUSECODE : QT02
     * TARGETWAREHOUSENAME : 青浦2号仓库
     * GOODSNUMBER : 3
     * STATUS : 0
     * REQUESTOPRNO : 3
     * TARGETOPRNO : null
     * REQUESTDATE : 2016-06-16T11:54:48
     * TARGETDATE : 0001-01-01T00:00:00
     */

    private int INVENTORYMOVEID;
    private String INVENTORYMOVECODE;
    private int GOODSID;
    private String GOODSCODE;
    private String GOODSNAME;
    private int REQUESTWAREHOUSEID;
    private String REQUESTWAREHOUSECODE;
    private String REQUESTWAREHOUSENAME;
    private int TARGETWAREHOUSEID;
    private String TARGETWAREHOUSECODE;
    private String TARGETWAREHOUSENAME;
    private int GOODSNUMBER;
    private String STATUS;
    private String REQUESTOPRNO;
    private Object TARGETOPRNO;
    private String REQUESTDATE;
    private String TARGETDATE;

    public int getINVENTORYMOVEID() {
        return INVENTORYMOVEID;
    }

    public void setINVENTORYMOVEID(int INVENTORYMOVEID) {
        this.INVENTORYMOVEID = INVENTORYMOVEID;
    }

    public String getINVENTORYMOVECODE() {
        return INVENTORYMOVECODE;
    }

    public void setINVENTORYMOVECODE(String INVENTORYMOVECODE) {
        this.INVENTORYMOVECODE = INVENTORYMOVECODE;
    }

    public int getGOODSID() {
        return GOODSID;
    }

    public void setGOODSID(int GOODSID) {
        this.GOODSID = GOODSID;
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

    public int getREQUESTWAREHOUSEID() {
        return REQUESTWAREHOUSEID;
    }

    public void setREQUESTWAREHOUSEID(int REQUESTWAREHOUSEID) {
        this.REQUESTWAREHOUSEID = REQUESTWAREHOUSEID;
    }

    public String getREQUESTWAREHOUSECODE() {
        return REQUESTWAREHOUSECODE;
    }

    public void setREQUESTWAREHOUSECODE(String REQUESTWAREHOUSECODE) {
        this.REQUESTWAREHOUSECODE = REQUESTWAREHOUSECODE;
    }

    public String getREQUESTWAREHOUSENAME() {
        return REQUESTWAREHOUSENAME;
    }

    public void setREQUESTWAREHOUSENAME(String REQUESTWAREHOUSENAME) {
        this.REQUESTWAREHOUSENAME = REQUESTWAREHOUSENAME;
    }

    public int getTARGETWAREHOUSEID() {
        return TARGETWAREHOUSEID;
    }

    public void setTARGETWAREHOUSEID(int TARGETWAREHOUSEID) {
        this.TARGETWAREHOUSEID = TARGETWAREHOUSEID;
    }

    public String getTARGETWAREHOUSECODE() {
        return TARGETWAREHOUSECODE;
    }

    public void setTARGETWAREHOUSECODE(String TARGETWAREHOUSECODE) {
        this.TARGETWAREHOUSECODE = TARGETWAREHOUSECODE;
    }

    public String getTARGETWAREHOUSENAME() {
        return TARGETWAREHOUSENAME;
    }

    public void setTARGETWAREHOUSENAME(String TARGETWAREHOUSENAME) {
        this.TARGETWAREHOUSENAME = TARGETWAREHOUSENAME;
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

    public String getREQUESTOPRNO() {
        return REQUESTOPRNO;
    }

    public void setREQUESTOPRNO(String REQUESTOPRNO) {
        this.REQUESTOPRNO = REQUESTOPRNO;
    }

    public Object getTARGETOPRNO() {
        return TARGETOPRNO;
    }

    public void setTARGETOPRNO(Object TARGETOPRNO) {
        this.TARGETOPRNO = TARGETOPRNO;
    }

    public String getREQUESTDATE() {
        return REQUESTDATE;
    }

    public void setREQUESTDATE(String REQUESTDATE) {
        this.REQUESTDATE = REQUESTDATE;
    }

    public String getTARGETDATE() {
        return TARGETDATE;
    }

    public void setTARGETDATE(String TARGETDATE) {
        this.TARGETDATE = TARGETDATE;
    }
}
