package com.xzsd.pc.hot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.hot.dao.HotDao;
import com.xzsd.pc.hot.entity.HotInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class HotService {
    @Resource
    private HotDao hotDao;

    /**
     * 新增热门位商品
     * @param hotInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveHot(HotInfo hotInfo){
        int countHot = hotDao.countHotCode(hotInfo);
        if (0 != countHot) {
            return AppResponse.bizError("热门位商品已存在，请重新输入！");
        }
        int countSort = hotDao.countSort(hotInfo);
        if(0 != countSort){
            return AppResponse.bizError("热门位序号已存在,请重新输入");
        }
        // 新增热门位商品
        int count = hotDao.saveHot(hotInfo);
        hotInfo.setIsDeleted(0);
        hotInfo.setHotId(StringUtil.getCommonCode(3));
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询热门商品详情
     * @param hotId
     * @return
     */
    public AppResponse findHotGoodsById(String hotId){
       HotInfo hotInfo = hotDao.findHotGoodsById(hotId);
        return AppResponse.success("查询成功",hotInfo);
    }

    /**
     * 修改热门位商品信息
     * @param hotInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsById(HotInfo hotInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        int countSort = hotDao.countHotCode(hotInfo);
        if(countSort != 0){
            return AppResponse.bizError("热门位商品已存在，请重新输入");
        }
        int count = hotDao.updateHotGoodsById(hotInfo);
        if(count == 0){
             appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 查询热门位商品分页
     */
    public AppResponse listHotGoods(HotInfo hotInfo){
        PageHelper.startPage(hotInfo.getPageNum(), hotInfo.getPageSize());
        List<HotInfo> hotInfos = hotDao.listHotGoods(hotInfo);
        //包装page对象
        PageInfo<HotInfo> pageData = new PageInfo<>(hotInfos);
        return AppResponse.success("查询成功",pageData);
    }

    /**
     * 删除热门位商品
     * @param hotId
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotId, String userId){
        List<String>listHotId = Arrays.asList(hotId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = hotDao.deleteHotGoods(listHotId,userId);
        if(count == 0){
            appResponse = AppResponse.bizError("删除失败,请重试");
        }
        return appResponse;
    }

    /**
     * 修改热门位商品数量
     * @param
     * @return
     */
    @Transactional (rollbackFor = Exception.class)
    public AppResponse updateHotGoodsShow(String hotGoodsCnt,String userId){
        int count = hotDao.updateHotGoodsShow(hotGoodsCnt,userId);
        if(count == 0){
             return AppResponse.bizError("数据有变化，请刷新");
        }
        return AppResponse.success("修改成功");
    }
}
