package com.xzsd.app.order.dao;

import com.xzsd.app.order.entity.OrderDetailsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDetailsDao {
    //新增订单明细
    int addOrderDetails(OrderDetailsInfo orderDetailsInfo);
}
