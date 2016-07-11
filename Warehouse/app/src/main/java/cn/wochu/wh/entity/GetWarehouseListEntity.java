package cn.wochu.wh.entity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/14 下午3:40
 * alter person：dayongxin
 * alter time：16/6/14 下午3:40
 * alter remark：
 */
public class GetWarehouseListEntity {

    /**
     * WAREHOUSEID : 8
     * WAREHOUSECODE : QT02
     * WAREHOUSENAME : 青浦2号仓库
     * WAREHOUSEPROVINCE : 上海
     * WAREHOUSECITY : 上海
     * WAREHOUSEDISTRICT : 青浦
     * WAREHOUSEADDRESS : 崧辉路189号
     * STATUS : 1
     * OPRNO : sa
     * CREATEDATE : 2016-06-02T03:54:46
     */

    private int WAREHOUSEID;
    private String WAREHOUSECODE;
    private String WAREHOUSENAME;
    private String WAREHOUSEPROVINCE;
    private String WAREHOUSECITY;
    private String WAREHOUSEDISTRICT;
    private String WAREHOUSEADDRESS;
    private String STATUS;
    private String OPRNO;
    private String CREATEDATE;

    public int getWAREHOUSEID() {
        return WAREHOUSEID;
    }

    public void setWAREHOUSEID(int WAREHOUSEID) {
        this.WAREHOUSEID = WAREHOUSEID;
    }

    public String getWAREHOUSECODE() {
        return WAREHOUSECODE;
    }

    public void setWAREHOUSECODE(String WAREHOUSECODE) {
        this.WAREHOUSECODE = WAREHOUSECODE;
    }

    public String getWAREHOUSENAME() {
        return WAREHOUSENAME;
    }

    public void setWAREHOUSENAME(String WAREHOUSENAME) {
        this.WAREHOUSENAME = WAREHOUSENAME;
    }

    public String getWAREHOUSEPROVINCE() {
        return WAREHOUSEPROVINCE;
    }

    public void setWAREHOUSEPROVINCE(String WAREHOUSEPROVINCE) {
        this.WAREHOUSEPROVINCE = WAREHOUSEPROVINCE;
    }

    public String getWAREHOUSECITY() {
        return WAREHOUSECITY;
    }

    public void setWAREHOUSECITY(String WAREHOUSECITY) {
        this.WAREHOUSECITY = WAREHOUSECITY;
    }

    public String getWAREHOUSEDISTRICT() {
        return WAREHOUSEDISTRICT;
    }

    public void setWAREHOUSEDISTRICT(String WAREHOUSEDISTRICT) {
        this.WAREHOUSEDISTRICT = WAREHOUSEDISTRICT;
    }

    public String getWAREHOUSEADDRESS() {
        return WAREHOUSEADDRESS;
    }

    public void setWAREHOUSEADDRESS(String WAREHOUSEADDRESS) {
        this.WAREHOUSEADDRESS = WAREHOUSEADDRESS;
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
