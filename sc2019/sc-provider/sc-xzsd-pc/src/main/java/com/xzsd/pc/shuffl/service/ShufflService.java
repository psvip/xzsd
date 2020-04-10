package com.xzsd.pc.shuffl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.shuffl.dao.ShufflDao;
import com.xzsd.pc.shuffl.entity.ShufflInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ShufflService {
    @Autowired
    private RedisOperator redisOperator;
    @Resource
    private ShufflDao shufflDao;
    @Resource
    private GoodsDao goodsDao;
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveShuffl(ShufflInfo shufflInfo) {
        // 校验轮播图商品是否存在
        int countShuffl = shufflDao.countShufflCode(shufflInfo);
        if (0 != countShuffl) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        int countSort = shufflDao.countSort(shufflInfo);
        if(countSort != 0){
            return AppResponse.bizError("序号已存在，请重新输入！");
        }
        // goodsInfo.setGoodsCode(StringUtil.getCommonCode(2));
        // goodsInfo.setIsDeleted(0);
        // 新增轮播图商品
        int count = shufflDao.saveShuffl(shufflInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    public AppResponse listShufll(ShufflInfo shufflInfo){
        PageHelper.startPage(shufflInfo.getPageNum(),shufflInfo.getPageSize());
        List<ShufflInfo> shufflInfos = shufflDao.listShuffl(shufflInfo);
        //包装page对象
        PageInfo<ShufflInfo> pageData = new PageInfo<>(shufflInfos);
        return  AppResponse.success("查询成功",pageData);
    }
    /**
     * 删除轮播图
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShufll(String shufflId, String userId){
        List<String>shufflList = Arrays.asList(shufflId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        //删除用户
        int count = shufflDao.deleteShuffl(shufflList,userId);
        if(count == 0){
            appResponse = AppResponse.bizError("删除失败,请重试");
        }
        return appResponse;
    }

    /**
     * 修改轮播图状态
     * @param shufflId
     * @param state
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
        public AppResponse updateShufflState(String shufflId, String state, String userId){
        AppResponse appResponse = AppResponse.success("修改成功");
        List<String>shufflList = Arrays.asList(shufflId.split(","));
        int count = shufflDao.updateShufflState(shufflList,state,userId);
        if(count == 0){
            return AppResponse.bizError("数据有变化，请更新");
        }
        return appResponse;
    }
    /**
     * 查询商品列表（分页）
     */
    public AppResponse findShufflGoods(GoodsInfo goodsInfo){
        /*if(redisOperator.get(goodsInfo.toString()) != null) {
            System.out.println("从redis查");
            PageInfo<GoodsInfo> pageData = JsonUtils.fromJson(redisOperator.get(goodsInfo.toString()),PageInfo.class);
            return AppResponse.success("查询成功", pageData);
        }*/

         //   System.out.println("从数据库查询");
            PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
            List<GoodsInfo> goodsInfos =  goodsDao.listGoods(goodsInfo);
            //包装page对象
            PageInfo<GoodsInfo> pageData = new PageInfo<>(goodsInfos);
           // redisOperator.set(goodsInfo.toString(),JsonUtils.toJson(pageData),300);
            return AppResponse.success("查询成功", pageData);

    }
}
