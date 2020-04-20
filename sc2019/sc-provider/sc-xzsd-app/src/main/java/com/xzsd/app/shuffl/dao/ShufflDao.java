package com.xzsd.app.shuffl.dao;
import com.xzsd.app.shuffl.entity.ShufflInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShufflDao {
    /**
     * 查询轮播图列表
     */
    List<ShufflInfo> listShuffl( );
}
