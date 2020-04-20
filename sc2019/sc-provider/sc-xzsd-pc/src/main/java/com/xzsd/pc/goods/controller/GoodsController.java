package com.xzsd.pc.goods.controller;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 *
 * 增删查改商品
 * @author  psvip
 *
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
   private  static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;
    /**
     * 新增商品
     */
    @PostMapping("saveGoods")
    public AppResponse saveGoods(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateBy(userId);
            AppResponse appResponse = goodsService.saveGoods(goodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 商品列表分页
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods (GoodsInfo goodsInfo){
        try{
            return goodsService.listGoods(goodsInfo);
        }catch (Exception e){
            logger.error("查询商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除商品
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode){
        try{
            String userId  = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsCode,userId);
        }catch (Exception e){
            logger.error("商品删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品信息
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setLastModifiedBy(userId);
            return goodsService.updateGoods(goodsInfo);
        }catch (Exception e){
            logger.error("修改商品信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 查看商品详情
     */
    @RequestMapping(value = "findGoodsById")
    public AppResponse findGoodsById(String goodsCode){
        try{
            return goodsService.findGoodsById(goodsCode);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     * 修改商品状态
     */
    @PostMapping("updateGoodsState")
    public AppResponse updateGoodsState(String goodsCode, String state){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.updateGoodsState(state,userId,goodsCode);
        }catch (Exception e){
            logger.error("修改商品信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
}
