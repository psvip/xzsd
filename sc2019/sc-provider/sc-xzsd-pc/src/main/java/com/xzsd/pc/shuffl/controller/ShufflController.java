package com.xzsd.pc.shuffl.controller;


import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.shuffl.entity.ShufflInfo;
import com.xzsd.pc.shuffl.service.ShufflService;
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
 * 增删查改轮播图
 * @author  psvip
 *
 */
@RestController
@RequestMapping("shuffl")
public class ShufflController {
    private  static final Logger logger = LoggerFactory.getLogger(ShufflController.class);
    @Resource
    ShufflService shufflService;

    /**
     * 新增轮播图
     * @param shufflInfo
     * @return
     */
    @PostMapping("saveShuffl")
    public AppResponse saveShuffl(ShufflInfo shufflInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            shufflInfo.setCreateBy(userId);
            AppResponse appResponse = shufflService.saveShuffl(shufflInfo);

            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询轮播图列表分页
     */
    @RequestMapping(value = "listShuffl")
    public AppResponse listShufll (ShufflInfo shufflInfo){
        try{
            return shufflService.listShufll(shufflInfo);
        }catch (Exception e){
            logger.error("查询轮播图列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除轮播图
     */
    @PostMapping("deleteShuffl")
    public AppResponse deleteShuffl(String shufflId){
        try{
            String userId  = AuthUtils.getCurrentUserId();
            return shufflService.deleteShufll(shufflId,userId);
        }catch (Exception e){
            logger.error("轮播图删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品状态
     */
    @PostMapping("updateShufflState")
    public AppResponse updateShufflState(String shufflId, String state){
        try {
            String userId = AuthUtils.getCurrentUserId();

            return shufflService.updateShufflState(shufflId,state,userId);
        }catch (Exception e){
            logger.error("修改轮播图信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 轮播图商品查询
     */
    @RequestMapping(value = "findShufflGoods")
    public AppResponse findShufflGoods (GoodsInfo goodsInfo){
        try{
            return shufflService.findShufflGoods(goodsInfo);
        }catch (Exception e){
            logger.error("查询商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
