package com.xzsd.pc.hot.dao;


import com.xzsd.pc.hot.entity.HotInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotDao {

    int countHotCode(HotInfo hotInfo);

    int saveHot(HotInfo hotInfo);

    HotInfo findHotGoodsById(@Param("hotId") String hotId);

    int updateHotGoodsById(HotInfo hotInfo);

    List<HotInfo>listHotGoods(HotInfo hotInfo);

    int deleteHotGoods(@Param("listHotId") List<String> listHotId, @Param("userId") String userId);
}
