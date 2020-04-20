package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 司机
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;
    @Resource
    private UserDao userDao;
    /**
     * 新增司机
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse saveDriver(DriverInfo driverInfo){
        //校验司机账号是否存在
        int countAcct = driverDao.countUserAcct(driverInfo);
        if(0 != countAcct){
            return AppResponse.bizError("账号已存在，请重新输入！");
        }
        String pwd = PasswordUtils.generatePassword(driverInfo.getPassword());
        driverInfo.setIsDeleted(0);
        driverInfo.setPassword(pwd);
        driverInfo.setUserCode(StringUtil.getCommonCode(4));
        int count = driverDao.saveDriver(driverInfo);
        int countUser = userDao.saveDriver(driverInfo);
        if(count == 0 || countUser == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return  AppResponse.success("新增成功",driverInfo);
    }
    /**
     * 查询司机详情
     */
    public AppResponse findDriverById(String userCode){
        DriverInfo driverInfo = driverDao.findDriverById(userCode);
        return AppResponse.success("查询成功",driverInfo);
    }
    /**
     * 修改门店信息
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateDriverById(DriverInfo driverInfo){
        AppResponse appResponse = AppResponse.success("修改成功");
        String userId = SecurityUtils.getCurrentUserId();
        int countAcct = driverDao.countUserAcct(driverInfo);
        if( 0 != countAcct){
            return AppResponse.bizError("司机账号已存在，请重新输入");
        }
        int count=driverDao.updateDriverById(driverInfo);
    //    int countDriver =userDao.updateDriverById(driverInfo);
        if(count == 0) {
            appResponse = AppResponse.success("数据有变化，请刷新");
            return appResponse;
        }
        return  appResponse;
    }
    /**
     * 查询门店列表
     */
    public AppResponse listDriver(DriverInfo driverInfo){
        String userId = SecurityUtils.getCurrentUserId();
        //判断角色 0管理员 1店长
        int count = userDao.getRole(userId);
        if(0 == count) {
            PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
            List<DriverInfo> driverInfos = driverDao.listDriver(driverInfo);
            //包装page对象
            PageInfo<DriverInfo> pageData = new PageInfo<>(driverInfos);
            return AppResponse.success("查询成功", pageData);
        }else if(1 == count){
            PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
            List<DriverInfo> driverInfos = driverDao.listDriverByMan(driverInfo,userId);
            //包装page对象
            PageInfo<DriverInfo> pageData = new PageInfo<>(driverInfos);
            return AppResponse.success("查询成功", pageData);
        }

        return AppResponse.bizError("查询失败");
    }
    /**
     * 删除门店
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse deleteDriver(String userCode,String userId){
        List<String>listDriverCode = Arrays.asList(userCode.split(","));
        int count = driverDao.deleteDriver(listDriverCode,userId);
        if(count == 0){
             return AppResponse.bizError("删除失败,请重试");
        }
        return AppResponse.success("删除成功");
    }
}
