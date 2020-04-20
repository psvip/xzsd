package com.xzsd.app.cart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.cart.entity.CartInfo;
import com.xzsd.app.cart.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 购物车增删改查
 * psvip
 * 2020-4-15
 */
@RestController
@RequestMapping("shopcart")
public class CartController {
    private  static final Logger logger = LoggerFactory.getLogger(CartController.class);
    @Resource
    CartService cartService;
    /**
     * 购物车新增
     */
    @PostMapping("saveCart")
    public AppResponse saveCart(CartInfo cartInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            cartInfo.setCreateBy(userId);
            AppResponse appResponse = cartService.saveCart(cartInfo);

            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询购物车
     */
    @RequestMapping("listShopcart")
    public AppResponse listShopcart(CartInfo cartInfo){
        try{
            return cartService.listShopcart(cartInfo);
        }catch (Exception e){
            logger.error("查询购物车列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改购物车数量
     */
    @PostMapping("saveGoods")
    public AppResponse saveGoods(String cartId,String goodsCnt){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return cartService.saveGoods(cartId,goodsCnt,userId);
        }catch (Exception e){
            logger.error("修改购物车数量错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 删除购物车
     */
    @PostMapping("deleteCart")
    public AppResponse deleteCart(String cartId){
        try{
            String userId  = SecurityUtils.getCurrentUserId();
            return cartService.deleteCart(cartId,userId);
        }catch (Exception e){
            logger.error("购物车删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
