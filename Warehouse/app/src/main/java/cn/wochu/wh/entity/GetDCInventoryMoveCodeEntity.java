package cn.wochu.wh.entity;

import java.util.List;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/16 下午5:10
 * alter person：dayongxin
 * alter time：16/6/16 下午5:10
 * alter remark：
 */
public class GetDCInventoryMoveCodeEntity {

    /**
     * RESULT : 1
     * MESSAGE : 请求成功
     * DATA : ["WOC00000068178"]
     */

    private String RESULT;
    private String MESSAGE;
    private List<String> DATA;

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

    public List<String> getDATA() {
        return DATA;
    }

    public void setDATA(List<String> DATA) {
        this.DATA = DATA;
    }
}
