package com.xzsd.app.cart.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.cart.dao.CartDao;
import com.xzsd.app.cart.entity.CartInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 购物车
 * psvip
 * 2020-4-15
 */
@Service
public class CartService {
    @Resource
    private CartDao cartDao;
    /**
     * demo 新增购物车
     * @param
     * @return
     * @Author psvip
     * @Date 2020-04-15
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveCart(CartInfo cartInfo) {
        // 校验商品是否还有库存
        int countGoods = cartDao.countGoodsCnt(cartInfo);
        if( countGoods == 0) {
            return AppResponse.bizError("商品已无库存，请选择其他商品！");
        }
        // 新增商品
        int count = cartDao.saveCart(cartInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 查询购物车列表
     */
    public AppResponse listShopcart(CartInfo cartInfo){
        String userCode = SecurityUtils.getCurrentUserId();
        cartInfo.setUserCode(userCode);
        List<CartInfo> cartInfos = cartDao.listShopcart(cartInfo);
        //包装page对象
        PageInfo<CartInfo> pageData = new PageInfo<>(cartInfos);
        return AppResponse.success("查询成功",pageData);
    }
    /**
     * 修改购物车数量
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse saveGoods(String cartId,String goodsCnt,String userId){
        AppResponse appResponse = AppResponse.success("修改成功");
        int count=cartDao.saveGoods(cartId,goodsCnt,userId);
        if(count == 0){
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }
    /**
     * 购物车删除
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCart(String cartId, String userId){
        List<String>listCartId = Arrays.asList(cartId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = cartDao.deleteCart(listCartId,userId);
        if(count == 0){
            appResponse = AppResponse.bizError("删除失败,请重试");
        }
        return appResponse;
    }
}
