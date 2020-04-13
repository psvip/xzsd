package com.xzsd.pc.customer.controller;

import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户管理查
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Resource
    CustomerService customerService;
    /**
     * 查询客户分页
     */
    @RequestMapping(value = "listCustomer")
    public AppResponse listCustomer (CustomerInfo customerInfo){
        try{
            return customerService.listCustomer(customerInfo);
        }catch (Exception e){
            logger.error("查询客户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
