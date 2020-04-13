package com.xzsd.pc.hot.dao;


import com.xzsd.pc.hot.entity.HotInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

public interface HotDao {
    /**
     * 热门位商品是否存在
     * @param hotInfo
     * @return
     */
    int countHotCode(HotInfo hotInfo);

    /**
     * 热门位序号是否已存在
     * @param hotInfo
     * @return
     */
    int countSort(HotInfo hotInfo);

    /**
     * 新增热门位商品
     * @param hotInfo
     * @return
     */
    int saveHot(HotInfo hotInfo);

    /**
     * 查询热门位商品详情
     * @param hotId
     * @return
     */
    HotInfo findHotGoodsById(@Param("hotId") String hotId);

    /**
     * 修改热门位商品信息
     * @param hotInfo
     * @return
     */
    int updateHotGoodsById(HotInfo hotInfo);

    /**
     * 查询热门位分页
     * @param hotInfo
     * @return
     */
    List<HotInfo>listHotGoods(HotInfo hotInfo);

    /**
     * 删除热门位商品
     * @param listHotId
     * @param userId
     * @return
     */
    int deleteHotGoods(@Param("listHotId") List<String> listHotId, @Param("userId") String userId);
    /**
     * 修改热门位商品数量
     */
    int updateHotGoodsShow(@Param("hotGoodsCnt")String hotGoodsCnt, @Param("userId")String userId);
}
