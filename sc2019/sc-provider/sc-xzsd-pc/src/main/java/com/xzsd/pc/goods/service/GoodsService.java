package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.JsonUtils;
import com.xzsd.pc.util.RedisOperator;
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
    @Autowired
    private RedisOperator redisOperator;
   /* @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;*/
    @Resource
    private GoodsDao goodsDao;

    /**
     * demo 新增商品
     * @param goodsInfo
     * @return
     * @Author psvip
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveGoods(GoodsInfo goodsInfo) {
        // 校验商品是否存在
        int countGoods = goodsDao.countGoodsCode(goodsInfo);
        if(0 != countGoods) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        // 新增商品
        int count = goodsDao.saveGoods(goodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 查询商品列表（分页）
     */
    public AppResponse listGoods(GoodsInfo goodsInfo){
            if(redisOperator.get(goodsInfo.toString()) != null) {
                System.out.println("从redis查");
                PageInfo<GoodsInfo> pageData = JsonUtils.fromJson(redisOperator.get(goodsInfo.toString()),PageInfo.class);
                return AppResponse.success("查询成功", pageData);
            }
            else {
                System.out.println("从数据库查询");
                PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
                List<GoodsInfo> goodsInfos = goodsDao.listGoods(goodsInfo);
                //包装page对象
                PageInfo<GoodsInfo> pageData = new PageInfo<>(goodsInfos);
                redisOperator.set(goodsInfo.toString(), JsonUtils.toJson(pageData),300);
                return AppResponse.success("查询成功", pageData);

            }
    }
    /**
     * 删除商品
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode, String userId){
        List<String>listGoodsCode = Arrays.asList(goodsCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");

        int count = goodsDao.deleteGoods(listGoodsCode,userId);
        if(count == 0){
            appResponse = AppResponse.bizError("删除失败,请重试");
        }
        return appResponse;
    }
    /**
     * 修改商品信息
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
       /* int countgoodscode = goodsDao.countGoodsCode(goodsInfo);
        if( 0 != countgoodscode){
            return AppResponse.bizError("商品已存在，请重新输入");

        }*/
        int count=goodsDao.updateGoods(goodsInfo);
        if(count == 0){
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }
    /**
     * 查询商品详细
     */
    public AppResponse findGoodsById(String goodsCode){
        GoodsInfo goodsInfo = goodsDao.findGoodsById(goodsCode);
        return AppResponse.success("查询成功",goodsInfo);
    }
    /**
     * 修改商品状态
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsState(String state, String userId, String goodsCode){
        List<String>listGoodsCode = Arrays.asList(goodsCode.split(","));
        AppResponse appResponse = AppResponse.success("修改成功",state);
        int count=goodsDao.updateGoodsState(state,userId,listGoodsCode);
        if(count == 0){
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }

}
