package com.xzsd.pc.cate.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.cate.entity.CateInfo;
import com.xzsd.pc.cate.service.CateService;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类增删查改
 */
@RestController
@RequestMapping("cate")
public class CateController {
    private  static final Logger logger = LoggerFactory.getLogger(CateController.class);
    @Resource
    private CateService cateService;
    /**
     * 新增商品分类
     */
    @PostMapping("saveCate")
    public AppResponse saveCate(CateInfo cateInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            cateInfo.setCreateBy(userId);
            cateInfo.setCateCode(StringUtil.getCommonCode(4));
            AppResponse appResponse = cateService.saveCate(cateInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
   /**
     * 查询商品分类列表
     */
    @RequestMapping(value = "listCate")
    public AppResponse listCate (){
        try{
            return cateService.listCate();
        }catch (Exception e){
            logger.error("查询商品分类异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     */
    @PostMapping("deleteCate")
    public AppResponse deleteCate(String cateCode){
        try{
            String userId  = SecurityUtils.getCurrentUserId();
            return cateService.deleteCate(cateCode,userId);
        }catch (Exception e){
            logger.error("商品分类删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品分类信息
     */
    @PostMapping("updateCate")
    public AppResponse updateCate(CateInfo cateInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            cateInfo.setLastModifiedBy(userId);
            return cateService.updateCate(cateInfo);
        }catch (Exception e){
            logger.error("修改商品分类信息错误",e);
            System.out.println(e.toString());
            throw  e;
        }
    }
    /**
     * 查看商品详情
     */
    @RequestMapping(value = "findCateById")
    public AppResponse findCateById(String cateCode){
        try{
            return cateService.findCateById(cateCode);
        }catch (Exception e){
            logger.error("查询失败",e);
            throw  e;
        }
    }
    /**
     * 查询商品一级分类
     */
    @RequestMapping("findGoodsClassOne")
    public AppResponse findGoodsClassOne(){
        try{
            return cateService.findGoodsClassOne();
        }catch (Exception e){
            logger.error("查询商品分类异常",e);
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
            return cateService.findGoodsClassTwo(classificationlOneId);
        }catch (Exception e){
            logger.error("查询商品分类异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
