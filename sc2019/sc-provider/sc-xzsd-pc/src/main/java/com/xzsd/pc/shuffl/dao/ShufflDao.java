package com.xzsd.pc.shuffl.dao;


import com.xzsd.pc.shuffl.entity.ShufflInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShufflDao {
    /**
     * 查看商品是否已存在
     */
    int countShufflCode(ShufflInfo shufflInfo);
    /**
     * 查看序号是否已存在
     */
    int countSort(ShufflInfo shufflInfo);
    /**
     *
     * 新增轮播图
     */
    int saveShuffl(ShufflInfo shufflInfo);
    /**
     * 查询轮播图列表
     */
    List<ShufflInfo> listShuffl(ShufflInfo shufflInfo);
    /**
     * 删除轮播图
     */
    int deleteShuffl(@Param("shufflList") List<String> shufflList, @Param("userId") String userId);
    /**
     * 修改轮播图状态
     */
    int updateShufflState(@Param("shufflList") List<String> shufflList, @Param("state") String state, @Param("userId") String userId);
}
