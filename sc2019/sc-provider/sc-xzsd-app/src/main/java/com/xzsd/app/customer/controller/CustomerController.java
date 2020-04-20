package com.xzsd.app.customer.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.entity.CustomerInfo;
import com.xzsd.app.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * app端客户增删查改
 * psvip
 * 2020-4-14
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    private  static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Resource
    CustomerService customerService;
    /**
     * 注册（新增）客户
     */
    @PostMapping("saveCustomer")
    public AppResponse saveCustomer(CustomerInfo customerInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            customerInfo.setCreateBy(userId);
            AppResponse appResponse = customerService.saveCustomer(customerInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("客户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询个人信息
     */
    @RequestMapping("appInformation")
    public AppResponse customerInformation(){
        String useCode = SecurityUtils.getCurrentUserId();
        return customerService.customerInformation(useCode);
    }

}
