package com.xzsd.app.hot.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.hot.dao.HotDao;
import com.xzsd.app.hot.entity.HotInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class HotService {
    @Resource
    private HotDao hotDao;
    /**
     * 查询热门位商品分页
     */
    public AppResponse listHotGoods(HotInfo hotInfo){
        int count = hotDao.getHotNum();
        hotInfo.setHotGoodsCnt(count);

        List<HotInfo> hotInfos = hotDao.listHotGoods(hotInfo);

        return AppResponse.success("查询成功",hotInfos);
    }

}
