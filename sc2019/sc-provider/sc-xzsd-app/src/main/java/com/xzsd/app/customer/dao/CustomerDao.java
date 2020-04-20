package com.xzsd.app.customer.dao;

import com.xzsd.app.customer.entity.CustomerInfo;
import org.apache.ibatis.annotations.Param;

public interface CustomerDao {
    /**
     * 新增客户
     */
    int saveCustomer(CustomerInfo customerInfo);
    /**
     * 查询用户信息
     */
    CustomerInfo customerInformation(@Param("userCode")String userCode);
}
