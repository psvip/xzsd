package com.xzsd.app.goods.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 *
 * app查询商品详情
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
     * 查看商品详情
     */
    @RequestMapping(value = "findAppGoodsById")
    public AppResponse findAppGoodsById(String goodsCode){
        try{
            return goodsService.findAppGoodsById(goodsCode);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     *商品一级分类查询
     */
    @RequestMapping("findGoodsClassOne")
    public AppResponse findGoodsClassOne(){
        try{
            return goodsService.findGoodsClassOne();
        }catch (Exception e){
            logger.error("查询商品一级分类异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询商品二级分类
     */
    @RequestMapping("findGoodsClassTwo")
    public AppResponse findGoodsClassTwo(String classificationlOneId){
        try{
            return goodsService.findGoodsClassTwo(classificationlOneId);
        }catch (Exception e){
            logger.error("查询商品二级分类异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
