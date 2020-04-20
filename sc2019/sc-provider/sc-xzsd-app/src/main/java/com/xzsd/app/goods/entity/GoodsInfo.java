package com.xzsd.app.goods.entity;

import java.util.Date;

/**
 * 商品字段
 *
 * @author psvip
 * 2020-3-26
 */
public class GoodsInfo  {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品代码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品书号
     */
    private String isbn;
    /**
     * 一级分类id
     */
    private String classficationlOneId;
    /**
     * 二级分类id
     */
    private String classficationlTwoId;
    /**
     * 商家名称
     */
    private String outsideName;
    /**
     * 商品库存
     */
    private int inventory;
    /**
     * 成本价
     */
    private String costPrice;
    /**
     * 在售价
     */
    private double sellPrice;
    /**
     * 定价
     */
    private double fixPrice;
    /**
     * 销量
     */
    private  int saleCnt;
    /**
     * 商品状态
     */
    private String state;
    /**
     * 上架时间
     */
    private  Date shelve;

    /**
     *
     * 商品评价等级
     */
    private String evaluationlevel;

    /**
     * 店铺名称
     */
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getEvaluationlevel() {
        return evaluationlevel;
    }

    public void setEvaluationlevel(String evaluationlevel) {
        this.evaluationlevel = evaluationlevel;
    }

    public String getClassficationlOne() {
        return classficationlOne;
    }

    public void setClassficationlOne(String classficationlOne) {
        this.classficationlOne = classficationlOne;
    }

    public String getClassficationlTwo() {
        return classficationlTwo;
    }

    public void setClassficationlTwo(String classficationlTwo) {
        this.classficationlTwo = classficationlTwo;
    }

    private String classficationlOne;

    private  String classficationlTwo;

    public int getSaleCnt() {
        return saleCnt;
    }

    public void setSaleCnt(int saleCnt) {
        this.saleCnt = saleCnt;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", goodsCode='" + goodsCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", classficationlOneId='" + classficationlOneId + '\'' +
                ", classficationlTwoId='" + classficationlTwoId + '\'' +
                ", outsideName='" + outsideName + '\'' +
                ", inventory=" + inventory +
                ", costPrice='" + costPrice + '\'' +
                ", sellPrice='" + sellPrice + '\'' +
                ", fixPrice='" + fixPrice + '\'' +
                ", saleCnt=" + saleCnt +
                ", state='" + state + '\'' +
                ", shelve=" + shelve +
                ", classficationlOne='" + classficationlOne + '\'' +
                ", classficationlTwo='" + classficationlTwo + '\'' +
                ", goodsPhoto='" + goodsPhoto + '\'' +
                ", goodsIntroduce='" + goodsIntroduce + '\'' +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", goodsAuthor='" + goodsAuthor + '\'' +
                ", goodsPress='" + goodsPress + '\'' +
                ", isDeleted=" + isDeleted +
                ", sortNo=" + sortNo +
                ", gmtCreate=" + gmtCreate +
                ", createBy='" + createBy + '\'' +
                ", gmtModified=" + gmtModified +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getShelve() {
        return shelve;
    }

    public void setShelve(Date shelve) {
        this.shelve = shelve;
    }

    /**
     * 商品图片
     */
    private String goodsPhoto;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品广告词
     */
    private String goodsDetail;
    /**
     * 商品作者
     */
    private String goodsAuthor;
    /**
     * 出版社
     */
    private String goodsPress;
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
     * 版本号
     */
    private String version;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getClassficationlOneId() {
        return classficationlOneId;
    }

    public void setClassficationlOneId(String classficationlOneId) {
        this.classficationlOneId = classficationlOneId;
    }

    public String getClassficationlTwoId() {
        return classficationlTwoId;
    }

    public void setClassficationlTwoId(String classficationlTwoId) {
        this.classficationlTwoId = classficationlTwoId;
    }

    public String getOutsideName() {
        return outsideName;
    }

    public void setOutsideName(String outsideName) {
        this.outsideName = outsideName;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }


    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getFixPrice() {
        return fixPrice;
    }

    public void setFixPrice(double fixPrice) {
        this.fixPrice = fixPrice;
    }
}
