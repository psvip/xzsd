package com.xzsd.app.shuffl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.shuffl.dao.ShufflDao;
import com.xzsd.app.shuffl.entity.ShufflInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 轮播图
 */
@Service
public class ShufflService {
    @Resource
    private ShufflDao shufflDao;
    /**
     * 查询轮播图列表分页
     * @return
     */
    public AppResponse listShufll( ){

        List<ShufflInfo> shufflInfos = shufflDao.listShuffl();
        return  AppResponse.success("查询成功",shufflInfos);
    }

}
