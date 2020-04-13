package com.xzsd.pc.driver.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 司机增删查改
 * psvip
 * 2020-4-12
 */
@RestController
@RequestMapping("driver")
public class DriverController {
    private  static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;
    /**
     * 新增司机
     */
    @PostMapping("saveDriver")
    public AppResponse saveDriver(DriverInfo driverInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateBy(userId);
            AppResponse appResponse = driverService.saveDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询司机详情
     */
    @RequestMapping("findDriverById")
    public AppResponse findDriverById(String userCode){
        try{
            return driverService.findDriverById(userCode);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     * 修改司机信息
     */
    @PostMapping("updateDriverById")
    public AppResponse updateDriverById(DriverInfo driverInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setLastModifiedBy(userId);
            return driverService.updateDriverById(driverInfo);
        }catch (Exception e){
            logger.error("修改司机信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 查询门店列表
     */
    @RequestMapping(value = "listDriver")
    public AppResponse listStore (DriverInfo driverInfo){
        try{
            return driverService.listDriver(driverInfo);
        }catch (Exception e){
            logger.error("查询司机列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除司机
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String userCode){
        try{
            String userId  = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(userCode,userId);
        }catch (Exception e){
            logger.error("司机删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
