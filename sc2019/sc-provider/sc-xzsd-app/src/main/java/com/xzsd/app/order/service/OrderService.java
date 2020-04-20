package com.xzsd.app.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.cart.dao.CartDao;
import com.xzsd.app.order.dao.OrderDao;
import com.xzsd.app.order.dao.OrderDetailsDao;
import com.xzsd.app.order.entity.OrderDetailsInfo;
import com.xzsd.app.order.entity.OrderInfo;
import com.xzsd.app.user.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private CartDao cartDao;
    @Resource
    private OrderDetailsDao orderDetailsDao;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse listOrder (OrderInfo orderInfo){
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        String userId = SecurityUtils.getCurrentUserId();
           List<OrderInfo> orderInfos = orderDao.listOrder(orderInfo);
           PageInfo<OrderInfo> pageData = new PageInfo<>(orderInfos);
           return AppResponse.success("查询成功",pageData);
       }

    /**
     * 查询订单详情
     */
    public AppResponse findOrderById(String orderId){
        return AppResponse.success("查询成功",orderDao.findOrderById(orderId));
    }
    /**
     * 修改订单状态
     * @param
     * @param userId
     * @return
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateOrderState(String orderId ,String orderState,String userId){
        AppResponse appResponse = AppResponse.success("修改成功",orderState);
        int count=orderDao.updateOrderState(orderId,orderState,userId);
        if(count == 0){
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }

    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo){
        orderInfo.setOrderId(StringUtil.getCommonCode(5));
        double orderSumMoney = 0;
        int buyNum = 0;
        for(OrderDetailsInfo item: orderInfo.getOrderDetailsInfos()){
            //从购物车结算，则删除购物车
            List<String> list = new ArrayList<>();
            if(item.getCartId() != null){
                list.add(item.getCartId());
                int count = cartDao.deleteCart(list, orderInfo.getCreateBy());
                if (count == 0) {
                    return AppResponse.bizError("删除购物车失败，请重试！");
                }
            }
            //新增订单
            item.setOrderDetailsId(StringUtil.getCommonCode(2));
            item.setOrderId(orderInfo.getOrderId());
            item.setCreateBy(orderInfo.getCreateBy());
            item.setTotalMoney(Double.parseDouble(item.getBuyNum())*item.getSellPrice());
            buyNum += Integer.parseInt(item.getBuyNum());
            orderSumMoney += item.getTotalMoney();
            int count = orderDetailsDao.addOrderDetails(item);
            if (count == 0) {
                return AppResponse.bizError("新增订单明细失败，请重试！");
            }
        }
        orderInfo.setBuyNum(buyNum + "");
        orderInfo.setOrderPrice(orderSumMoney);
        int count = orderDao.addOrder(orderInfo);
        if (count == 0) {
            return AppResponse.bizError("新增订单失败，请重试！");
        }
        return AppResponse.success("新增订单成功！");
    }

}
