package cn.wochu.wh.constant;

/**
 * Copyright 2016 DoubleDa
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ApiConstants {
    /**
     * 测试服务器
     */
    public static final String APP_HOST = "http://127.0.0.1:8080/“;
    /**
     * 正式服务器
     */
    //public static final String APP_HOST = "http://127.0.0.1:8080/";


    /**
     * 用户登录{Account/LogOn?userName=sa&password=8}
     */
    public static final String URL_ACCOUNT_LOGON = APP_HOST + "Account/LogOn?";
    /**
     * 以下为商品上架
     */

    /**
     * 扫描商品{DCOnShelves/GetDCWarehouseGoodsInfo?GoodsCode=0101010992}
     */
    public static final String URL_DCONSHELVES_GETDCWAREHOUSEGOODSINFO = APP_HOST + "DCOnShelves/GetDCWarehouseGoodsInfo?";

    /**
     * 商品上架{DCOnShelves/SetDCOnShelves?userID=3&objType=上架}
     */
    public static final String URL_SETDCONSHELVES = APP_HOST + "DCOnShelves/SetDCOnShelves?";

    /**
     * 以下为商品下架
     */
    /**
     * 扫描商品{DCOffShelves/GetDCWarehouseGoodsInfo?GoodsCode=0101010992}
     */
    public static final String URL_DCOFFSHELVES_GETDCWAREHOUSEGOODSINFO = APP_HOST + "DCShelves/GetDCWarehouseGoodsInfo?";
    /**
     * 商品下架{DCOffShelves/SetOffShelves?userID=3&objType=下架}
     */
    public static final String URL_SETDCOFFSHELVES = APP_HOST + "DCOffShelves/SetOffShelves?";
    /**
     * 获取商品信息{DCOffShelves/CheckGetLocationGoodsInfo?GoodsCode=0101010992}
     */
    public static final String URL_DCOFFSHELVES_CHECKGETLOCATIONGOODSINFO = APP_HOST + "DCOffShelves/CheckGetLocationGoodsInfo?";
    /**
     * 库存查询{DCShelves/GetDCWarehouseGoodsInfo?GoodsCode=0101010992}
     */
    public static final String URL_DCSHELVES_GETDCWAREHOUSEGOODSINFO = APP_HOST + "DCShelves/GetDCWarehouseGoodsInfo?";
    /**
     * 前置仓库信息{http://116.228.118.218:9099/DCShelves/GetDCWarehouseInfo}
     */
    public static final String URL_DCSHELVES_GETDCWAREHOUSEINFO = APP_HOST + "DCShelves/GetDCWarehouseInfo";


    /**
     * 新的
     */
    public static final String URL_PUBLIC_GETLOOKUPITEMLIST = APP_HOST + "Public/GetLookUpItemList?";
    /**
     * 上架扫描商品
     */
    public static final String URL_DCSHELVES_GETDCGOODSINFO = APP_HOST + "DCShelves/GetDCGoodsInfo?";
    /**
     * 转仓下架
     */
    public static final String URL_DCOFFSHELVES_SETDCTRANSOFFSHELVES = APP_HOST + "DCOffShelves/SetDCTransOffShelves?";
    public static final String URL_DCONSHELVES_GETDCTRANSONSHELVES_MOVECODE = APP_HOST + "DCOnShelves/GetDCTransOnShelves?";
    public static final String URL_DCONSHELVES_GETDCINVENTORYMOVECODE = APP_HOST + "DCOnShelves/GetDCInventoryMoveCode?";
    public static final String URL_DCONSHELVES_SETDCTRANSONSHELVES = APP_HOST + "DCOnShelves/SetDCTransOnShelves?";
    public static final String URL_DCSHELVES_SETDCINVENTORY = APP_HOST + "DCShelves/SetDCInventory?";
    public static final String URL_DCOFFSHELVES_GETDCJDORDERINFO = APP_HOST + "DCOffShelves/GetDCJDOrderInfo?";

    /**
     * 第三方订单
     */
    public static final String URL_DCOFFSHELVES_SETJDOFFSHELVES = APP_HOST + "DCOffShelves/SetJDOffShelves?";
}
