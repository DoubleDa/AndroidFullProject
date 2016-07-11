package cn.wochu.wh.entity;

/**
 * project name：PrefixStorageProject
 * class describe：基本的Model Bean
 * create person：dayongxin
 * create time：16/6/7 上午11:48
 * alter person：dayongxin
 * alter time：16/6/7 上午11:48
 * alter remark：
 */
public class BaseEntity<T> {
    private String RESULT;
    private String MESSAGE;
    private T DATA;

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

    public T getDATA() {
        return DATA;
    }

    public void setDATA(T DATA) {
        this.DATA = DATA;
    }
}
