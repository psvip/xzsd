package com.xzsd.pc.store.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 门店增删查改
 * psvip
 * 2020-4-11
 */
@RestController
@RequestMapping("store")
public class StoreController {
    private  static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Resource
    private StoreService storeService;
    /**
     * 新增门店
     */
    @PostMapping("saveStore")
    public AppResponse saveStore(StoreInfo storeInfo){
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateBy(userId);
            AppResponse appResponse = storeService.saveStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询门店详情
     */
    @RequestMapping(value = "findStoreById")
    public AppResponse findStoreById(String storeCode){
        try{
            return storeService.findStoreById(storeCode);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     * 修改门店信息
     */
    @PostMapping("updateStoreById")
    public AppResponse updateStoreById(StoreInfo storeInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setLastModifiedBy(userId);
            return storeService.updateStoreById(storeInfo);
        }catch (Exception e){
            logger.error("修改门店信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 查询门店列表
     */
    @RequestMapping(value = "listStore")
    public AppResponse listStore (StoreInfo storeInfo){
        try{
            return storeService.listStore(storeInfo);
        }catch (Exception e){
            logger.error("查询门店列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除门店
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeCode){
        try{
            String userId  = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeCode,userId);
        }catch (Exception e){
            logger.error("门店删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 省份下拉查询
     */
    @RequestMapping("findStoreAddress")
    public AppResponse findStoreClassOne(String parentCode){
        try{
            return storeService.findStoreAdd(parentCode);
        }catch (Exception e){
            logger.error("查询省份异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
