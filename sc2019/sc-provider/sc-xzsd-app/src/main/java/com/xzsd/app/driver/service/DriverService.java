package com.xzsd.app.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.store.entity.StoreInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 司机
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;
    /**
     * 查询门店列表
     */
    public AppResponse findStoreById(String userCode){
        List<StoreInfo> storeInfos = driverDao.findStoreById(userCode);
        return AppResponse.success("查询成功",storeInfos);
    }
}
