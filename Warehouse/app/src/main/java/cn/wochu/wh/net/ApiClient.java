package cn.wochu.wh.net;


import cn.wochu.wh.constant.ApiConstants;
import cn.wochu.wh.utils.StringUtils;

/**
 * project name：PrefixStorageProject
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午2:50
 * alter person：dayongxin
 * alter time：16/6/12 下午2:50
 * alter remark：
 */
public class ApiClient {

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    public static String getAccountLogOn(String userName, String password) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_ACCOUNT_LOGON);
        sb.append("userName=");
        sb.append(userName);
        sb.append("&");
        sb.append("password=");
        sb.append(password);
        return sb.toString();
    }

    /**
     * 扫描商品
     *
     * @param goodsCode
     * @return
     */
    public static String getDCWarehouseGoodsInfo(String goodsCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCONSHELVES_GETDCWAREHOUSEGOODSINFO);
        sb.append("GoodsCode=");
        sb.append(goodsCode);
        return sb.toString();
    }

    /**
     * 提交上架信息
     *
     * @param userCode
     * @param objType
     * @return
     */
    public static String postDCOnShelves(String userCode, String objType) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_SETDCONSHELVES);
        sb.append("userCode=");
        sb.append(userCode);
        sb.append("&");
        sb.append("objType=");
        sb.append(objType);
        return sb.toString();
    }

    /**
     * 商品下架
     *
     * @param goodsCode
     * @return
     */
    public static String getDCWarehouseOffGoodsInfo(String goodsCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCOFFSHELVES_GETDCWAREHOUSEGOODSINFO);
        sb.append("GoodsCode=");
        sb.append(goodsCode);
        return sb.toString();
    }

    /**
     * 提交下架信息
     *
     * @param userCode
     * @param objType
     * @return
     */
    public static String postDCOffShelves(String userCode, String objType) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_SETDCOFFSHELVES);
        sb.append("userCode=");
        sb.append(userCode);
        sb.append("&");
        sb.append("objType=");
        sb.append(objType);
        return sb.toString();
    }

    /**
     * 获取商品定位信息
     *
     * @param goodsCode
     * @return
     */
    public static String getLocationGoodsInfo(String goodsCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCOFFSHELVES_CHECKGETLOCATIONGOODSINFO);
        sb.append("GoodsCode=");
        sb.append(goodsCode);
        return sb.toString();
    }

    /**
     * 库存查询
     *
     * @param goodsCode
     * @return
     */
    public static String getStockGoodsInfo(String goodsCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCSHELVES_GETDCWAREHOUSEGOODSINFO);
        sb.append("GoodsCode=");
        sb.append(goodsCode);
        return sb.toString();
    }

    /**
     * 转仓下架
     *
     * @param goodsCode
     * @return
     */
    public static String getTransferOffShelvesInfo(String goodsCode, int WarehouseID) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCOFFSHELVES_GETDCWAREHOUSEGOODSINFO);
        sb.append("GoodsCode=");
        sb.append(goodsCode);
        sb.append("&");
        sb.append("WarehouseID=");
        sb.append(WarehouseID);
        return sb.toString();
    }

    /**
     * 库存查询
     *
     * @param goodsCode
     * @return
     */
    public static String getWarehouseInfo(String goodsCode, int wareId) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCSHELVES_GETDCWAREHOUSEGOODSINFO);
        sb.append("GoodsCode=");
        sb.append(goodsCode);
        sb.append("&");
        sb.append("WarehouseID=");
        sb.append(wareId);
        return sb.toString();
    }

    public static String getDCWarehouseInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCSHELVES_GETDCWAREHOUSEINFO);
        return sb.toString();
    }

    /**
     * 新的
     */
    /**
     * @param type
     * @return
     */
    public static String GetLookUpItemList(String type) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_PUBLIC_GETLOOKUPITEMLIST);
        sb.append("LookupName=");
        sb.append(type);
        return sb.toString();
    }

    public static String getDCOnWarehouseGoodsInfo(String mGoodsCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCSHELVES_GETDCGOODSINFO);
        sb.append("GoodsCode=");
        sb.append(mGoodsCode);
        return sb.toString();
    }

    public static String postDCTransOffShelves(String userCode, int mFromWarehouseID, int mToWarehouseID) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCOFFSHELVES_SETDCTRANSOFFSHELVES);
        sb.append("userCode=");
        sb.append(userCode);
        sb.append("&");
        sb.append("FromWarehouseID=");
        sb.append(mFromWarehouseID);
        sb.append("&");
        sb.append("ToWarehouseID=");
        sb.append(mToWarehouseID);
        return sb.toString();
    }

    public static String getDCTransOnShelvesMoveCode(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCONSHELVES_GETDCTRANSONSHELVES_MOVECODE);
        sb.append("MoveCode=");
        sb.append(str);
        return sb.toString();
    }

    public static String GetDCInventoryMoveCode(String mTargetWarehouseCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCONSHELVES_GETDCINVENTORYMOVECODE);
        sb.append("TargetWarehouseCode=");
        sb.append(mTargetWarehouseCode);
        return sb.toString();
    }

    public static String postDCTransOnShelves(String userCode, String mMoveCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCONSHELVES_SETDCTRANSONSHELVES);
        sb.append("userCode=");
        sb.append(userCode);
        sb.append("&");
        sb.append("MoveCode=");
        sb.append(mMoveCode);
        return sb.toString();
    }

    public static String postCheckWarehouseData(String userCode) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCSHELVES_SETDCINVENTORY);
        sb.append("userCode=");
        sb.append(userCode);
        return sb.toString();
    }

    public static String getDCJDOrderInfo(String orderNum) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCOFFSHELVES_GETDCJDORDERINFO);
        sb.append("OrderNO=");
        sb.append(orderNum);
        return sb.toString();
    }

    /**
     * 第三方订单
     */
    public static String setJDOffShelves(String JDOrderNO, String userCode, String objType) {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiConstants.URL_DCOFFSHELVES_SETJDOFFSHELVES);
        sb.append("JDOrderNO=");
        sb.append(JDOrderNO);
        sb.append("&");
        sb.append("userCode=");
        sb.append(userCode);
        sb.append("&");
        sb.append("objType=");
        sb.append(objType);
        return sb.toString();
    }
}
