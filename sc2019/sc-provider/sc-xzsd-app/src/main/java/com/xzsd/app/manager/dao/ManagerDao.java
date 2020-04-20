package com.xzsd.app.manager.dao;

import com.xzsd.app.manager.entity.ManagerInfo;
import org.apache.ibatis.annotations.Param;

public interface ManagerDao {
   ManagerInfo managerInformation(@Param("userCode") String userCode);
}
