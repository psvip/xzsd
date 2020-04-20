package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetailsInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 查询订单列表（管理员）
     */
    List<OrderInfo>listOrderAll(OrderInfo orderInfo);
    /**
     * 查询订单列表（店长）
     */
    List<OrderInfo>listOrder(OrderInfo orderInfo);
    /**
     * 查询订单详情
     */
    List<OrderDetailsInfo> findOrderById(OrderDetailsInfo orderDetailsInfo);
    /**
     * 修改订单状态
     */
    int updateOrderState( @Param("listOrderId") List<String> listOrderId,@Param("orderState")String orderState,@Param("userId")String userId);
}
