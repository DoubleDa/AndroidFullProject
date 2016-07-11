package cn.wochu.wh.entity.off;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/23 上午11:07
 * alter person：dayongxin
 * alter time：16/6/23 上午11:07
 * alter remark：
 */
public class OffShelvesResultEntity {

    /**
     * RESULT : 1
     * MESSAGE : 请求成功
     * DATA : true
     */

    private String RESULT;
    private String MESSAGE;
    private boolean DATA;

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

    public boolean isDATA() {
        return DATA;
    }

    public void setDATA(boolean DATA) {
        this.DATA = DATA;
    }
}
