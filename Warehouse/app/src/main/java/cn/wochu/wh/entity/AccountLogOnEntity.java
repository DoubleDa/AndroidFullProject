package cn.wochu.wh.entity;

/**
 * project name：PrefixStorageProject
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午1:38
 * alter person：dayongxin
 * alter time：16/6/12 下午1:38
 * alter remark：
 */
public class AccountLogOnEntity {

    /**
     * USERID : 3
     * USERCODE : sa
     * PASSWORD : 8
     * USERNAME : 开发者
     * WAREHOUSEID : 7
     * WAREHOUSECODE : QT01
     * WAREHOUSENAME : 2222
     * EntityState : 3
     * Selected : false
     */

    private int USERID;
    private String USERCODE;
    private String PASSWORD;
    private String USERNAME;
    private int WAREHOUSEID;
    private String WAREHOUSECODE;
    private String WAREHOUSENAME;
    private int EntityState;
    private boolean Selected;

    public int getUSERID() {
        return USERID;
    }

    public void setUSERID(int USERID) {
        this.USERID = USERID;
    }

    public String getUSERCODE() {
        return USERCODE;
    }

    public void setUSERCODE(String USERCODE) {
        this.USERCODE = USERCODE;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

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

    public int getEntityState() {
        return EntityState;
    }

    public void setEntityState(int EntityState) {
        this.EntityState = EntityState;
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean Selected) {
        this.Selected = Selected;
    }
}
