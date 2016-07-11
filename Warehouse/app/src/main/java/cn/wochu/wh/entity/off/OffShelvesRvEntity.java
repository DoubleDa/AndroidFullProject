package cn.wochu.wh.entity.off;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/20 下午6:12
 * alter person：dayongxin
 * alter time：16/6/20 下午6:12
 * alter remark：
 */
public class OffShelvesRvEntity {
    private String goodsCode;
    private String goodsName;
    private String goodsNum;

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    private int goodsId;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public OffShelvesRvEntity(String goodsCode, String goodsName, int goodsId, String goodsNum) {
        this.goodsCode = goodsCode;
        this.goodsName = goodsName;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
    }


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
}
