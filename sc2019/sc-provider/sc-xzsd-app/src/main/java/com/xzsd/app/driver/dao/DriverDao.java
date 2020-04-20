package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;

public interface DriverDao {
    /**
     * 查询司机信息
     * @param userCode
     * @return
     */
    DriverInfo driverInformation(@Param("userCode")String userCode);
}
