package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AddressInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 门店
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;
    @Resource
    private UserDao userDao;
    /**
     * 新增门店
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveStore(StoreInfo storeInfo){
        //校验门店编号是否存在
        int countStore = storeDao.countStoreId(storeInfo);
        if(0 != countStore){
            return AppResponse.bizError("门店已存在，请重新输入！");
        }
        storeInfo.setIsDeleted(0);
        storeInfo.setStoreCode(StringUtil.getCommonCode(4));
        int count = storeDao.saveStore(storeInfo);
        if(count == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return  AppResponse.success("新增成功",storeInfo);
    }
    /**
     * 查询门店详情
     */
    public AppResponse findStoreById(String storeCode){
        StoreInfo storeInfo = storeDao.findStoreById(storeCode);
        return AppResponse.success("查询成功",storeInfo);
    }
    /**
     * 修改门店信息
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateStoreById(StoreInfo storeInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
       /* int countStorecode = storeDao.countStoreId(storeInfo);
        if( 0 != countStorecode){
            return AppResponse.bizError("门店已存在，请重新输入");

        }*/
        int count=storeDao.updateStoreById(storeInfo);
        if(count == 0){
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }
    /**
     * 查询门店列表
     */
    public AppResponse listStore(StoreInfo storeInfo){
        String userId = SecurityUtils.getCurrentUserId();
        //判断角色 0管理员 1店长
        int count = userDao.getRole(userId);
        if(0 == count) {
            PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
            List<StoreInfo> storeInfos = storeDao.listStore(storeInfo);
            //包装page对象
            PageInfo<StoreInfo> pageData = new PageInfo<>(storeInfos);
            return AppResponse.success("查询成功", pageData);
        }
        else if(1 == count){
          //  storeInfo.setManagerCode(userId);
            storeInfo.setManagerCode(userId);
            PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
            List<StoreInfo> storeInfos = storeDao.listStoreByManager(storeInfo);
            //包装page对象
            PageInfo<StoreInfo> pageData = new PageInfo<>(storeInfos);
            return AppResponse.success("查询成功", pageData);
        }
        return AppResponse.bizError("查询失败");
    }
    /**
     * 删除门店
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse deleteStore(String storeCode,String userId){
        List<String>listStoreCode = Arrays.asList(storeCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        int count = storeDao.deleteStore(listStoreCode,userId);
        if(count == 0){
            appResponse = AppResponse.bizError("删除失败,请重试");
        }
        return appResponse;
    }
    /**
     * 省市区下拉查询
     */
    public AppResponse findStoreAdd(String parentCode){
        List<AddressInfo> addressInfos = storeDao.findStoreAdd(parentCode);
        return  AppResponse.success("查询成功",addressInfos);
    }
}
