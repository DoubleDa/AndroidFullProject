package cn.wochu.wh.entity.on;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/20 下午4:23
 * alter person：dayongxin
 * alter time：16/6/20 下午4:23
 * alter remark：
 */
public class OnShelvesUploadEntity {
    private int GOODSID;
    private String GOODSCODE;
    private int WAREHOUSEID;

    public OnShelvesUploadEntity(String GOODSCODE, int GOODSID, int WAREHOUSEID, String ACTUALQTY, String OPRNO) {
        this.GOODSCODE = GOODSCODE;
        this.GOODSID = GOODSID;
        this.WAREHOUSEID = WAREHOUSEID;
        this.ACTUALQTY = ACTUALQTY;
        this.OPRNO = OPRNO;
    }

    public String getGOODSCODE() {
        return GOODSCODE;
    }

    public void setGOODSCODE(String GOODSCODE) {
        this.GOODSCODE = GOODSCODE;
    }

    private String ACTUALQTY;
    private String OPRNO;


    public int getGOODSID() {
        return GOODSID;
    }

    public void setGOODSID(int GOODSID) {
        this.GOODSID = GOODSID;
    }


    public int getWAREHOUSEID() {
        return WAREHOUSEID;
    }

    public void setWAREHOUSEID(int WAREHOUSEID) {
        this.WAREHOUSEID = WAREHOUSEID;
    }

    public String getACTUALQTY() {
        return ACTUALQTY;
    }

    public void setACTUALQTY(String ACTUALQTY) {
        this.ACTUALQTY = ACTUALQTY;
    }

    public String getOPRNO() {
        return OPRNO;
    }

    public void setOPRNO(String OPRNO) {
        this.OPRNO = OPRNO;
    }
}
