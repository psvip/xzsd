package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品类
 */
public interface GoodsDao {
    /**
     * 统计商品
     * @param goodsInfo 用户信息
     * @return
     */
    int countGoodsCode(GoodsInfo goodsInfo);

    /**
     * 新增商品
     * @param goodsInfo 商品信息
     * @return
     */
    int saveGoods(GoodsInfo goodsInfo);
    /**
     * 查询所有商品信息
     *
     */
    List<GoodsInfo> listGoods(GoodsInfo goodsInfo);
    /**
     * 删除商品
     */
    int deleteGoods(@Param("listGoodsCode") List<String> listGoodsCode, @Param("userId") String userId);
    /**
     * 修改商品信息
     */
    int updateGoods(GoodsInfo goodsInfo);
    /**
     * 查询商品详情
     */
    GoodsInfo findGoodsById(@Param("goodsCode") String goodsCode);
    /**
     * 修改商品状态
     */
    int updateGoodsState(@Param("state") String state, @Param("userId") String userId, @Param("listGoodsCode") List<String> listGoodsCode);
    /**
     *
     */
    /**
     * 轮播图中查询商品分页
     */
    List<GoodsInfo> findShufflGoods(GoodsInfo goodsInfo);
}
