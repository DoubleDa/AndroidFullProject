package cn.wochu.wh.entity.troff;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/23 下午1:47
 * alter person：dayongxin
 * alter time：16/6/23 下午1:47
 * alter remark：
 */
public class TransferOffShelvesResultEntity {

    /**
     * RESULT : 1
     * MESSAGE : 请求成功
     * DATA : 转仓下架成功！
     */

    private String RESULT;
    private String MESSAGE;
    private String DATA;

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

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }
}
