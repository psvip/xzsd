package com.xzsd.app.order.dao;


import com.xzsd.app.order.entity.OrderDetailsInfo;
import com.xzsd.app.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    /**
     * 查询订单列表
     */
    List<OrderInfo>listOrder(OrderInfo orderInfo);
    /**
     * 修改订单状态
     */
    int updateOrderState(@Param("orderId") String orderId, @Param("orderState") String orderState, @Param("userId") String userId);
    /**
     * 新增订单
     */
    int addOrder(OrderInfo orderInfo);
    /**
     * 查询详情
     */
    OrderDetailsInfo findOrderById(@Param("orderId") String orderId);
}
