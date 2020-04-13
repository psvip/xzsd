package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户
 */
public interface CustomerDao {
    /**
     * 查询订单列表（管理员）
     */
    List<CustomerInfo> listCustomerAll(CustomerInfo customerInfo);
    /**
     * 查询订单列表（店长）
     */
    List<CustomerInfo>listCustomer(CustomerInfo customerInfo);
}
