package com.xzsd.app.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.goods.dao.GoodsDao;
import com.xzsd.app.goods.entity.CateInfo;
import com.xzsd.app.goods.entity.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;
    /**
     * 查询商品详细
     */
    public AppResponse findAppGoodsById(String goodsCode){
        String userId = SecurityUtils.getCurrentUserId();
        GoodsInfo goodsInfo = goodsDao.findAppGoodsById(goodsCode,userId);
        return AppResponse.success("查询成功",goodsInfo);
    }
    /**
     * 查询商品一级分类
     */
    public AppResponse findGoodsClassOne(){
        List<CateInfo> cateInfos = goodsDao.findGoodsClassOne();
        return  AppResponse.success("查询成功",cateInfos);
    }
    /**
     * 查询商品二级分类
     */
    public AppResponse findGoodsClassTwo(String classificationlOneId){
        List<CateInfo> cateInfos = goodsDao.findGoodsClassTwo(classificationlOneId);
        return  AppResponse.success("查询成功",cateInfos);
    }

}
