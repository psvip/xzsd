package com.xzsd.pc.cate.dao;


import com.xzsd.pc.cate.entity.CateInfo;
import com.xzsd.pc.cate.entity.CateOne;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类
 * @author  psvip
 * 2020-3-27
 */
public interface CateDao {
    /**
     * 商品分类是否存在
     * @param cateInfo
     * @return
     */
    int countCateCode(CateInfo cateInfo);
    /**
     * 新增商品分类
     */
    int saveCate(CateInfo cateInfo);
    /**
     * 查询商品分类列表
     */
    List<CateOne>listCate();
    /**
     * 删除商品分类
     */
    int deleteCate(@Param("cateCode") String cateCode, @Param("userId") String userId);
    /**
     * 修改商品分类
     */
    int updateCate(CateInfo cateInfo);
    /**
     * 查询是否有子类
     */
    int countZiclass(@Param("cateCode") String cateCode);
    /**
     * 查询商品分类详情
     */
    CateInfo findCateById(@Param("cateCode") String cateCode);
    /**
     * 查询商品一级分类
     */
    List<CateInfo> findGoodsClassOne();
    /**
     * 查询商品一级分类下二级分类
     */
    List<CateInfo>findGoodsClassTwo(@Param("classificationlOneId") String classificationlOneId);
}
