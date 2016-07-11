package cn.wochu.wh.entity.check;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/21 下午3:15
 * alter person：dayongxin
 * alter time：16/6/21 下午3:15
 * alter remark：
 */
public class GoodsCheckResultEntity {

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
