package com.xzsd.app.cart.dao;

import com.xzsd.app.cart.entity.CartInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车
 */
public interface CartDao {
    /**
     * 查询商品库存
     * @param cartInfo
     * @return
     */
    int countGoodsCnt(CartInfo cartInfo);
    /**
     * 新增购物车
     */
    int saveCart(CartInfo cartInfo);
    /**
     * 查询购物车列表
     */
    List<CartInfo> listShopcart(CartInfo cartInfo);
    /**
     * 修改购物车数量
     */
     int saveGoods(@Param("cartId")String cartId ,@Param("goodsCnt")String goodsCnt,@Param("userId")String userId);
    /**
     * 删除购物车
     */
     int deleteCart(@Param("listCartId") List<String> listCartId, @Param("userId") String userId);

}
