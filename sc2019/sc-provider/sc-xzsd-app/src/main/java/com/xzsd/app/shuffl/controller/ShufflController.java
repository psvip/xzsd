package com.xzsd.app.shuffl.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.shuffl.entity.ShufflInfo;
import com.xzsd.app.shuffl.service.ShufflService;
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
     * 查询轮播图列表分页
     */
    @RequestMapping(value = "findshufflstate")
    public AppResponse listShufll ( ){
        try{
            return shufflService.listShufll();
        }catch (Exception e){
            logger.error("查询轮播图列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
