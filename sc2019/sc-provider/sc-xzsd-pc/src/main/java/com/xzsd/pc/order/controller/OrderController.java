package com.xzsd.pc.order.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.sun.jersey.core.impl.provider.entity.XMLRootObjectProvider;
import com.xzsd.pc.order.entity.OrderDetailsInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.util.AppResponse;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
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
    public AppResponse findOrderById(OrderDetailsInfo orderDetailsInfo){
        try{
            return orderService.findOrderById(orderDetailsInfo);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     * 订单状态修改
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String orderId,String orderState){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderState(orderId,orderState,userId);
        }catch (Exception e){
            logger.error("修改订单错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
}
