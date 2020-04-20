package com.xzsd.app.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;

import com.xzsd.app.goods.entity.GoodsInfo;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *订单管理增删查改
 */
@RestController
@RequestMapping("order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;
    /**
     * 查询订单分页
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder (OrderInfo orderInfo){
        try{
            return orderService.listOrder(orderInfo);
        }catch (Exception e){
            logger.error("查询订单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询订单详情
     */
    @RequestMapping("findOrderById")
    public AppResponse findOrderById(String orderId){
        try{
            return orderService.findOrderById(orderId);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     * 订单状态修改
     */
   @RequestMapping("updateOrderState")
    public AppResponse updateOrderState(String orderId,String orderState,String userId){
        try {
             userId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderState(orderId,orderState,userId);
        }catch (Exception e){
            logger.error("修改订单错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
   @PostMapping("addOrder")
    public AppResponse addOrder(OrderInfo orderInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setCreateBy(userId);
            orderInfo.setUserCode(userId);
            return  orderService.addOrder(orderInfo);
        }catch (Exception e){
            logger.error("订单新增错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
   /* @PostMapping("addOrderEvaluation")
    public AppResponse addOrderEvaluation()*/
}
