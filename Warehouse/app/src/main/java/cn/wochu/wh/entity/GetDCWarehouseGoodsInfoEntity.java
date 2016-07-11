package cn.wochu.wh.entity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午5:40
 * alter person：dayongxin
 * alter time：16/6/12 下午5:40
 * alter remark：
 */
public class GetDCWarehouseGoodsInfoEntity {

    /**
     * GOODSID : 2282
     * GOODSCODE : WOC000000681
     * GOODSNAME : 北大荒有机米2.5kg
     * BARCODE : null
     * UNITNAME : 袋
     */

    private int GOODSID;
    private String GOODSCODE;
    private String GOODSNAME;
    private Object BARCODE;
    private String UNITNAME;

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

    public Object getBARCODE() {
        return BARCODE;
    }

    public void setBARCODE(Object BARCODE) {
        this.BARCODE = BARCODE;
    }

    public String getUNITNAME() {
        return UNITNAME;
    }

    public void setUNITNAME(String UNITNAME) {
        this.UNITNAME = UNITNAME;
    }
}
