package cn.wochu.wh.entity;

/**
 * project name：Warehouse
 * class describe：
 * create person：dayongxin
 * create time：16/6/13 下午2:59
 * alter person：dayongxin
 * alter time：16/6/13 下午2:59
 * alter remark：
 */
public class CheckGetLocationGoodsInfo {

    @Override
    public String toString() {
        return
                "InventoryID=" + InventoryID +
                        "\n" +
                        "GoodsID=" + GoodsID +
                        "\n" + "GoodsCode=" + GoodsCode +
                        "\n" + "GoodsName=" + GoodsName +
                        "\n" + "WarehouseID=" + WarehouseID +
                        "\n" + "WarehouseCode=" + WarehouseCode +
                        "\n" + "WarehouseName=" + WarehouseName +
                        "\n" + "GoodsBatchCode=" + GoodsBatchCode +
                        "\n" + "ProductionDate=" + ProductionDate +
                        "\n" + "ExpiryDays=" + ExpiryDays +
                        "\n" + "UsefulQty=" + UsefulQty +
                        "\n" + "ActualQty=" + ActualQty +
                        "\n" + "OprNO='" + OprNO +
                        "\n" + "CreateDate='" + CreateDate
                ;
    }

    /**
     * InventoryID : 26
     * GoodsID : 7822
     * GoodsCode : 0101010992
     * GoodsName : Lucy1225001
     * WarehouseID : 8
     * WarehouseCode : QT02
     * WarehouseName : 青浦2号仓库
     * GoodsBatchCode : 010101099251206030
     * ProductionDate : 2016-06-07T11:24:08
     * ExpiryDays : 3
     * UsefulQty : 10
     * ActualQty : 0
     * OprNO : sa
     * CreateDate : 2016-06-07T11:24:08
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
