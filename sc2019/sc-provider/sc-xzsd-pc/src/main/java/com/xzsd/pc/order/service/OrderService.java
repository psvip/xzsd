package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse listOrder (OrderInfo orderInfo){
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderInfo> orderInfos = orderDao.listOrder(orderInfo);
        //包装page对象
        PageInfo<OrderInfo> pageData = new PageInfo<>(orderInfos);
        return AppResponse.success("查询成功",pageData);
    }
}
