package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderInfo;

import java.util.List;

public interface OrderDao {
    /**
     * 查询订单列表
     */
    List<OrderInfo>listOrder(OrderInfo orderInfo);
}
