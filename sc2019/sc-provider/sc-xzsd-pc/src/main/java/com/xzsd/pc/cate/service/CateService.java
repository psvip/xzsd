package com.xzsd.pc.cate.service;


import com.xzsd.pc.cate.dao.CateDao;
import com.xzsd.pc.cate.entity.CateInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类
 */
@Service
public class CateService {
    @Resource
    private CateDao cateDao;

    /**
     * demo 新增商品分类
     * @param  cateInfo
     * @return
     * @Author psvip
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveCate(CateInfo cateInfo) {
        // 校验商品是否存在
        int countCate = cateDao.countCateCode(cateInfo);
        if(0 != countCate) {
            return AppResponse.bizError("商品分类已存在，请重新输入！");
        }
       /*  cateInfo.setCateCode(StringUtil.getCommonCode(2));*/
         cateInfo.setIsDeleted(0);
        int count = cateDao.saveCate(cateInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
     /**
         * 查询商品一级分类
       */
    public AppResponse listCate(){

        List<CateInfo> cateInfos = cateDao.listCate();
            for(CateInfo cateInfo : cateInfos){
                cateInfo.getNextCateVos().addAll(cateDao.listCateTwo(cateInfo.getCateCode()));
            }
        return  AppResponse.success("查询成功",cateInfos);
    }


    /**
     * 删除商品分类
      */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCate(String cateCode, String userId){

        AppResponse appResponse = AppResponse.success("删除成功！");
        int count1 = cateDao.countZiclass(cateCode);
        if(count1 > 0 ){
            return AppResponse.bizError("删除失败");
        }
        int count2 = cateDao.deleteCate(cateCode,userId);
        if(count2 == 0){
            appResponse = AppResponse.bizError("删除失败,请重试");
        }

        return appResponse;
    }
    /**
     * 修改商品分类信息
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateCate(CateInfo cateInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        int countcatecode = cateDao.countCateCode(cateInfo);
        if( 0 != countcatecode){
            return AppResponse.bizError("商品已存在，请重新输入");

        }
        int count=cateDao.updateCate(cateInfo);
        if(count == 0){
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }
    /**
     * 查询商品详细
      */


    public AppResponse findCateById(String cateCode){
        CateInfo cateInfo = cateDao.findCateById(cateCode);
        return AppResponse.success("查询成功",cateInfo);
    }

    /**
     * 查询商品一级分类
     */
    public AppResponse findGoodsClassOne(){
        List<CateInfo> cateInfos = cateDao.findGoodsClassOne();

        return  AppResponse.success("查询成功",cateInfos);
    }
    /**
     * 查询商品一级分类
     */
    public AppResponse findGoodsClassTwo(String classificationlOneId){
        List<CateInfo> cateInfos = cateDao.findGoodsClassTwo(classificationlOneId);

        return  AppResponse.success("查询成功",cateInfos);
    }
}
