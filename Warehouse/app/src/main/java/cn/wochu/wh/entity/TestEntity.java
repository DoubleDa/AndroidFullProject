package cn.wochu.wh.entity;

import java.util.List;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/7/7 下午2:58
 * alter person：dayongxin
 * alter time：16/7/7 下午2:58
 * alter remark：
 */
public class TestEntity {


    /**
     * RESULT : 1
     * MESSAGE : 请求成功
     * DATA : [{"SHEETID":"I0160706161750922","RATIONDATE":"2016-07-07T00:00:00","APPORDERNO":"5-104","CHECKSTATUS":"-1"},{"SHEETID":"I0160706161301832","RATIONDATE":"2016-07-07T00:00:00","APPORDERNO":"5-92","CHECKSTATUS":"-1"}]
     */

    private String RESULT;
    private String MESSAGE;
    /**
     * SHEETID : I0160706161750922
     * RATIONDATE : 2016-07-07T00:00:00
     * APPORDERNO : 5-104
     * CHECKSTATUS : -1
     */

    private List<DATAEntity> DATA;

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public List<DATAEntity> getDATA() {
        return DATA;
    }

    public void setDATA(List<DATAEntity> DATA) {
        this.DATA = DATA;
    }

    public static class DATAEntity {
        private String SHEETID;
        private String RATIONDATE;
        private String APPORDERNO;
        private String CHECKSTATUS;

        public String getSHEETID() {
            return SHEETID;
        }

        public void setSHEETID(String SHEETID) {
            this.SHEETID = SHEETID;
        }

        public String getRATIONDATE() {
            return RATIONDATE;
        }

        public void setRATIONDATE(String RATIONDATE) {
            this.RATIONDATE = RATIONDATE;
        }

        public String getAPPORDERNO() {
            return APPORDERNO;
        }

        public void setAPPORDERNO(String APPORDERNO) {
            this.APPORDERNO = APPORDERNO;
        }

        public String getCHECKSTATUS() {
            return CHECKSTATUS;
        }

        public void setCHECKSTATUS(String CHECKSTATUS) {
            this.CHECKSTATUS = CHECKSTATUS;
        }
    }
}
