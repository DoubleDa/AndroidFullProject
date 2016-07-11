package cn.wochu.wh.entity.troff;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/28 下午4:19
 * alter person：dayongxin
 * alter time：16/6/28 下午4:19
 * alter remark：
 */
public class TransferOffShelvesEntity {
    private String GoodsCode;
    private String GoodsName;
    private int ActualQty;
    private String offGoodsNum;

    public TransferOffShelvesEntity(String goodsCode, String goodsName, int actualQty, String offGoodsNum) {
        GoodsCode = goodsCode;
        GoodsName = goodsName;
        ActualQty = actualQty;
        this.offGoodsNum = offGoodsNum;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        GoodsCode = goodsCode;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public int getActualQty() {
        return ActualQty;
    }

    public void setActualQty(int actualQty) {
        ActualQty = actualQty;
    }

    public String getOffGoodsNum() {
        return offGoodsNum;
    }

    public void setOffGoodsNum(String offGoodsNum) {
        this.offGoodsNum = offGoodsNum;
    }
}
