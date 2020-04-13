package com.xzsd.pc.cate.entity;

import java.util.Date;

public class CateTwo {
    /**
     * 二级分类名称
     */
    private  String cateTwoName;
    /**
     * 二级分类编号
     */
    private  String cateTwoCode;
    /**
     * 二级分类备注
     */
    private  String cateTwoNote;
    /**
     * 上级编号
     */
    private String cateCodeParent;
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

    public String getCateTwoName() {
        return cateTwoName;
    }

    public void setCateTwoName(String cateTwoName) {
        this.cateTwoName = cateTwoName;
    }

    public String getCateTwoCode() {
        return cateTwoCode;
    }

    public void setCateTwoCode(String cateTwoCode) {
        this.cateTwoCode = cateTwoCode;
    }

    public String getCateTwoNote() {
        return cateTwoNote;
    }

    public void setCateTwoNote(String cateTwoNote) {
        this.cateTwoNote = cateTwoNote;
    }

    public String getCateCodeParent() {
        return cateCodeParent;
    }

    public void setCateCodeParent(String cateCodeParent) {
        this.cateCodeParent = cateCodeParent;
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
}
