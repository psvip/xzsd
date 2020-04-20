package com.xzsd.pc.hot.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hot.entity.HotInfo;
import com.xzsd.pc.hot.service.HotService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 热门位商品增删查改
 */
@RestController
@RequestMapping("hot")
public class HotController {
    private  static final Logger logger = LoggerFactory.getLogger(HotController.class);
    @Resource
    private HotService hotService;

    /**
     * 新增热门位商品
     */
    @PostMapping("saveHot")
    public AppResponse saveHot(HotInfo hotInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotInfo.setCreateBy(userId);
            AppResponse appResponse = hotService.saveHot(hotInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("热门位商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询热门位商品详情
     */
    @PostMapping("findHotGoodsById")
    public AppResponse findHotGoodsById(String hotId) {
        try{
            return hotService.findHotGoodsById(hotId);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     * 修改热门位商品
     */
    @PostMapping("updateHotGoodsById")
    public AppResponse updateHotGoodsById(HotInfo hotInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            hotInfo.setLastModifiedBy(userId);
            return hotService.updateHotGoodsById(hotInfo);
        }catch (Exception e){
            logger.error("修改热门位商品信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 查询热门位商品分页
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods (HotInfo hotInfo){
        try{
            return hotService.listHotGoods(hotInfo);
        }catch (Exception e){
            logger.error("查询热门位商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门位商品
     * @param hotId
     * @return
     */
    @RequestMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotId){
        try{
            String userId  = SecurityUtils.getCurrentUserId();
            return hotService.deleteHotGoods(hotId,userId);
        }catch (Exception e){
            logger.error("热门位商品删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 热门位商品数量修改
     */
    @PostMapping("updateHotGoodsShow")
    public AppResponse updateHotGoodsShow(String hotGoodsCnt){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return hotService.updateHotGoodsShow(hotGoodsCnt,userId);
        }catch (Exception e){
            logger.error("修改热门位商品数量信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }

}
