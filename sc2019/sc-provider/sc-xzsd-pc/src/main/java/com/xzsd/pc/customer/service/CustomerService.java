package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * psvip
 * 2020-4-10
 * 客户
 */
@Service
public class CustomerService {
    @Resource
    CustomerDao customerDao;
    @Resource
    UserDao userDao;

    /**
     * 查询顾客列表
     * @param customerInfo
     * @return
     */
    public AppResponse listCustomer(CustomerInfo customerInfo){
        String userId = SecurityUtils.getCurrentUserId();
        int count = userDao.getRole(userId);
        if(count == 0){
            PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
            List<CustomerInfo> customerInfos = customerDao.listCustomerAll(customerInfo);
            PageInfo<CustomerInfo> pageData = new PageInfo<>(customerInfos);
            return AppResponse.success("查询成功",pageData);
        }else if(count == 1){
            PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
            customerInfo.setUserCode(userId);
            List<CustomerInfo> customerInfos = customerDao.listCustomer(customerInfo);
            PageInfo<CustomerInfo> pageData = new PageInfo<>(customerInfos);
            return AppResponse.success("查询成功",pageData);
        }
        return AppResponse.bizError("查询失败");
    }
}
