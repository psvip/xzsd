package com.xzsd.app.hot.dao;



import com.xzsd.app.hot.entity.HotInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HotDao {
    /**
     * 查询热门位分页
     * @param hotInfo
     * @return
     */
    List<HotInfo>listHotGoods(HotInfo hotInfo);
    /**
     * 获取热门位商品数量
     */
    int getHotNum();
}
