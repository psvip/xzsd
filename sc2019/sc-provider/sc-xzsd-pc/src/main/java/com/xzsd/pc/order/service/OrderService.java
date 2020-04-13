package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 订单
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private UserDao userDao;
    /**
     * 新增订单
     */

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse listOrder (OrderInfo orderInfo){
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        String userId = SecurityUtils.getCurrentUserId();
        //判断角色 0是管理员 1是店长
       int count = userDao.getRole(userId);
       if(count == 0){
           List<OrderInfo> orderInfos = orderDao.listOrderAll(orderInfo);
           PageInfo<OrderInfo> pageData = new PageInfo<>(orderInfos);
           return AppResponse.success("查询成功",pageData);
       }else if(count == 1){
           orderInfo.setUserId(userId);
           List<OrderInfo> orderInfos = orderDao.listOrder(orderInfo);
           PageInfo<OrderInfo> pageData = new PageInfo<>(orderInfos);
           return AppResponse.success("查询成功",pageData);
       }
        return  AppResponse.bizError("查询失败");
    }
    /**
     * 查询订单详情
     */
 /*   public AppResponse findOrderById(String orderId){

    }*/
    /**
     * 修改订单状态
     * @param
     * @param userId
     * @return
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateOrderState(String orderId ,String orderState,String userId){
        List<String>listOrderId = Arrays.asList(orderId.split(","));
        AppResponse appResponse = AppResponse.success("修改成功",orderState);
        int count=orderDao.updateOrderState(orderId,orderState,userId,listOrderId);
        if(count == 0){
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }

}
