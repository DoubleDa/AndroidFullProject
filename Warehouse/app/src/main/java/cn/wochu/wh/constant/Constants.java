package cn.wochu.wh.constant;

/**
 * project name：PrefixStorageProject
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午3:16
 * alter person：dayongxin
 * alter time：16/6/12 下午3:16
 * alter remark：
 */
public class Constants {
    /**
     * sp存储信息
     */
    public static final String SP_ACCOUNT_LOGON_USERID = "userid";
    public static final String SP_ACCOUNT_LOGON_USERCODE = "usercode";
    public static final String SP_ACCOUNT_LOGON_PASSWORD = "password";
    public static final String SP_ACCOUNT_LOGON_USERNAME = "username";
    public static final String SP_ACCOUNT_LOGON_ENTITYSTATE = "entitystate";
    public static final String SP_ACCOUNT_LOGON_SELECTED = "selected";
    public static final String SP_ACCOUNT_LOGON_WAREHOUSEID = "warehouseid";
    public static final String SP_ACCOUNT_LOGON_WAREHOUSECODE = "WAREHOUSECODE";
    public static final String SP_ACCOUNT_LOGON_WAREHOUSENAME = "WAREHOUSENAME";

    /**
     * 商品上架提交参数
     */
    public static final String PARAM_GOODSCODE = "GOODSCODE";
    public static final String PARAM_GOODSID = "GOODSID";
    public static final String PARAM_WAREHOUSEID = "WAREHOUSEID";
    public static final String PARAM_GOODSBATCHCODE = "GOODSBATCHCODE";
    public static final String PARAM_PRODUCTIONDATE = "PRODUCTIONDATE";
    public static final String PARAM_EXPIRYDAYS = "EXPIRYDAYS";
    public static final String PARAM_USEFULQTY = "USEFULQTY";
    public static final String PARAM_ACTUALQTY = "ACTUALQTY";
    public static final String PARAM_STATUS = "STATUS";
    public static final String PARAM_OPRNO = "OPRNO";
    public static final String PARAM_CREATEDATE = "CREATEDATE";

    /**
     * 商品下架提交参数
     */
    public static final String OFF_PARAM_INVENTORYID = "InventoryID";
    public static final String OFF_PARAM_GOODSID = "GoodsID";
    public static final String OFF_PARAM_GOODSCODE = "GoodsCode";
    public static final String OFF_PARAM_GOODSNAME = "GoodsName";
    public static final String OFF_PARAM_WAREHOUSEID = "WarehouseID";
    public static final String OFF_PARAM_WAREHOUSECODE = "WarehouseCode";
    public static final String OFF_PARAM_WAREHOUSENAME = "WarehouseName";
    public static final String OFF_PARAM_GOODSBATCHCODE = "GoodsBatchCode";
    public static final String OFF_PARAM_PRODUCTIONDATE = "ProductionDate";
    public static final String OFF_PARAM_EXPIRYDAYS = "ExpiryDays";
    public static final String OFF_PARAM_USEFULQTY = "UsefulQty";
    public static final String OFF_PARAM_ACTUALQTY = "ActualQty";
    public static final String OFF_PARAM_OPRNO = "OprNO";
    public static final String OFF_PARAM_CREATEDATE = "CreateDate";


    /**
     * 新加
     */
    public static final String GETLOOKUPITEMLISTTYPEON = "DCONSHELVESTYPE";
    public static final String GETLOOKUPITEMLISTTYPEOFF = "DCOFFSHELVESTYPE";

    /**
     * 第三方订单状态
     */
    public static final String ORDER_STATE_UNABLE = "0";
    public static final String ORDER_STATE_ENABLE = "1";
    public static final String ORDER_STATE_CANCELED = "2";
}
