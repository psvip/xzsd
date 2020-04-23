package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 司机
 */
public interface DriverDao {
    /**
     * 查询个人信息
     * @param userCode
     * @return
     */
    DriverInfo driverInformation(@Param("userCode")String userCode);
    /**
     * 查询门店列表
     */
     List<StoreInfo> findStoreById(@Param("userCode")String userCode);
}
