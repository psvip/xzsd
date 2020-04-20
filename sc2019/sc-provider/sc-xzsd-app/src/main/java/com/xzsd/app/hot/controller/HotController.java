package com.xzsd.app.hot.controller;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.hot.entity.HotInfo;
import com.xzsd.app.hot.service.HotService;
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
     * 查询热门位商品分页
     */
    @RequestMapping(value = "findHotGoodsShow")
    public AppResponse listHotGoods (HotInfo hotInfo){
        try{
            return hotService.listHotGoods(hotInfo);
        }catch (Exception e){
            logger.error("查询热门位商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
