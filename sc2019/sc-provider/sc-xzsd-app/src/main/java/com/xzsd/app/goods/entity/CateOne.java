package com.xzsd.app.goods.entity;

import java.util.Date;
import java.util.List;

public class CateOne {
    /**
     * 一级分类名称
     */
    private  String cateOneName;
    /**
     * 一级分类编号
     */
    private  String cateOneCode;
    /**
     * 一级分类备注
     */
    private  String cateOneNote;
    /**
     * 二级分类列表
     */
    private List<CateTwo> TwoList;
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

    public String getCateOneName() {
        return cateOneName;
    }

    public void setCateOneName(String cateOneName) {
        this.cateOneName = cateOneName;
    }

    public String getCateOneCode() {
        return cateOneCode;
    }

    public void setCateOneCode(String cateOneCode) {
        this.cateOneCode = cateOneCode;
    }

    public String getCateOneNote() {
        return cateOneNote;
    }

    public void setCateOneNote(String cateOneNote) {
        this.cateOneNote = cateOneNote;
    }

    public List<CateTwo> getTwoList() {
        return TwoList;
    }

    public void setTwoList(List<CateTwo> twoList) {
        TwoList = twoList;
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
}
