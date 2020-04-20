package com.xzsd.app.goods.dao;


import com.xzsd.app.goods.entity.CateInfo;
import com.xzsd.app.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品类
 */
public interface GoodsDao {

    /**
     * 查询商品详情
     */
    GoodsInfo findAppGoodsById(@Param("goodsCode") String goodsCode,@Param("userId")String userId);
    /**
     * 查询商品一级分类
     */
    List<CateInfo> findGoodsClassOne();
    /**
     * 查询商品一级分类下二级分类
     */
    List<CateInfo>findGoodsClassTwo(@Param("classificationlOneId") String classificationlOneId);
}
