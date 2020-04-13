package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 司机
 */
public interface DriverDao {
    /**
     * 查询账号是否存在
     */
    int countUserAcct(DriverInfo driverInfo);
    /**
     * 新增司机
     */
    int saveDriver(DriverInfo driverInfo);
    /**
     * 查询司机详情
     */
    DriverInfo findDriverById(@Param("userCode")String userCode);
    /**
     * 修改司机信息
     */
    int updateDriverById(DriverInfo driverInfo);
    /**
     * 查询司机列表（管理员）
     */
    List<DriverInfo> listDriver(DriverInfo driverInfo);
    /**
     * 查询司机列表（店长）
     */
    List<DriverInfo> listDriverByMan(DriverInfo driverInfo,@Param("userId")String userId);
    /**
     * 删除司机
     */
    int deleteDriver(@Param("listDriverCode")List<String>listDriverCode,@Param("userId")String userId);
}
