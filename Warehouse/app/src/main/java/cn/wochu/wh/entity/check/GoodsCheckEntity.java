package cn.wochu.wh.entity.check;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/21 下午1:50
 * alter person：dayongxin
 * alter time：16/6/21 下午1:50
 * alter remark：
 */
public class GoodsCheckEntity {


    /**
     * InventoryID : 81
     * GoodsID : 8204
     * GoodsCode : WOC000002895
     * GoodsName : 清美老豆腐320g
     * WarehouseID : 7
     * WarehouseCode : QT01
     * WarehouseName : 青浦1号仓库
     * GoodsBatchCode : WOC0000028956062017
     * ProductionDate : 2016-06-16T12:00:00
     * ExpiryDays : 3
     * UsefulQty : 0
     * ActualQty : 31
     * OprNO : 开发者
     * CreateDate : 2016-06-20T05:46:53
     */

    private int InventoryID;
    private int GoodsID;
    private String GoodsCode;
    private String GoodsName;
    private int WarehouseID;
    private String WarehouseCode;
    private String WarehouseName;
    private String GoodsBatchCode;
    private String ProductionDate;
    private int ExpiryDays;
    private int UsefulQty;
    private int ActualQty;
    private String OprNO;
    private String CreateDate;

    public GoodsCheckEntity(int goodsID, String goodsName, String goodsCode, int actualQty, int usefulQty) {
        GoodsID = goodsID;
        GoodsName = goodsName;
        GoodsCode = goodsCode;
        ActualQty = actualQty;
        UsefulQty = usefulQty;
    }

    public int getInventoryID() {
        return InventoryID;
    }

    public void setInventoryID(int InventoryID) {
        this.InventoryID = InventoryID;
    }

    public int getGoodsID() {
        return GoodsID;
    }

    public void setGoodsID(int GoodsID) {
        this.GoodsID = GoodsID;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String GoodsCode) {
        this.GoodsCode = GoodsCode;
    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String GoodsName) {
        this.GoodsName = GoodsName;
    }

    public int getWarehouseID() {
        return WarehouseID;
    }

    public void setWarehouseID(int WarehouseID) {
        this.WarehouseID = WarehouseID;
    }

    public String getWarehouseCode() {
        return WarehouseCode;
    }

    public void setWarehouseCode(String WarehouseCode) {
        this.WarehouseCode = WarehouseCode;
    }

    public String getWarehouseName() {
        return WarehouseName;
    }

    public void setWarehouseName(String WarehouseName) {
        this.WarehouseName = WarehouseName;
    }

    public String getGoodsBatchCode() {
        return GoodsBatchCode;
    }

    public void setGoodsBatchCode(String GoodsBatchCode) {
        this.GoodsBatchCode = GoodsBatchCode;
    }

    public String getProductionDate() {
        return ProductionDate;
    }

    public void setProductionDate(String ProductionDate) {
        this.ProductionDate = ProductionDate;
    }

    public int getExpiryDays() {
        return ExpiryDays;
    }

    public void setExpiryDays(int ExpiryDays) {
        this.ExpiryDays = ExpiryDays;
    }

    public int getUsefulQty() {
        return UsefulQty;
    }

    public void setUsefulQty(int UsefulQty) {
        this.UsefulQty = UsefulQty;
    }

    public int getActualQty() {
        return ActualQty;
    }

    public void setActualQty(int ActualQty) {
        this.ActualQty = ActualQty;
    }

    public String getOprNO() {
        return OprNO;
    }

    public void setOprNO(String OprNO) {
        this.OprNO = OprNO;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }
}
