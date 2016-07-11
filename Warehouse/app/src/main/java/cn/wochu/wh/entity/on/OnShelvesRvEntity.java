package cn.wochu.wh.entity.on;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/17 下午5:14
 * alter person：dayongxin
 * alter time：16/6/17 下午5:14
 * alter remark：
 */
public class OnShelvesRvEntity {

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * goodsName : 土豆丝
     * goodsCode : WOC201
     * goodsNum : 12
     * goodsUnit : 袋
     */

    private int goodsId;

    public OnShelvesRvEntity(int goodsId, String goodsName, String goodsCode, String goodsNum, String goodsUnit) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsCode = goodsCode;
        this.goodsNum = goodsNum;
        this.goodsUnit = goodsUnit;
    }

    private String goodsName;
    private String goodsCode;

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    private String goodsNum;
    private String goodsUnit;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }


    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }
}
