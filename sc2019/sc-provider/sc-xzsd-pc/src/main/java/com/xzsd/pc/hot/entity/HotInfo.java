package com.xzsd.pc.hot.entity;

import java.util.Date;

/**
 * 热门商品
 * 2020-4-8
 * psvip
 */
public class HotInfo {
    /**
     * 商品id
     */
    private String goodsCode;
    /**
     * 热门位排序
     */
    private String hotSort;
    /**
     * 热门位id
     */
    private String hotId;

    public String getHotId() {
        return hotId;
    }

    public void setHotId(String hotId) {
        this.hotId = hotId;
    }

    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 序号
     */
    private int sortNo;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 更新时间
     */
    private Date gmtModified;
    /**
     * 更新者
     */
    private String lastModifiedBy;
    /**
     * 页码
     */
    private int pageSize;

    /**
     *商品名称
     */
    private String goodsName;

    /**
     *商品售价
     */
    private String sellPrice;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 版本号
     */
    private  String version;

    /**
     * 热门位商品数量
     */
    private String hotGoodsCnt;

    public String getHotGoodsCnt() {
        return hotGoodsCnt;
    }

    public void setHotGoodsCnt(String hotGoodsCnt) {
        this.hotGoodsCnt = hotGoodsCnt;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getHotSort() {
        return hotSort;
    }

    public void setHotSort(String hotSort) {
        this.hotSort = hotSort;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
