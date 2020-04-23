package com.xzsd.app.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("driver")
/**
 * 司机门店查询
 */
public class DriverController {
    private  static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;
    /**
     * 司机门店列表查询
     */
    @RequestMapping("findStoreById")
    public AppResponse findStoreById(){
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            return driverService.findStoreById(userCode);
        } catch (Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
