package com.neusoft.webauth.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import com.neusoft.webauth.base.constant.GlobalConstant;
import com.neusoft.webauth.base.entity.Tree;

import com.neusoft.webauth.menu.dao.MenuDao;
import com.neusoft.webauth.menu.entity.Menu;
import com.neusoft.webauth.user.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

/*
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */

@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;
    @Resource
    private UserDao userDao;
    /**
     * 功能：查询菜单列表
     */
    public AppResponse listMenus(){
        List<Menu> menuList = menuDao.listMenus();
        return AppResponse.success("查询成功",menuList);
    }
    /*
     * 部门：南京软件研发中心
     * 功能：删除菜单
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/8/30
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode,String userId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除菜单
      int count =  menuDao.deleteMenu(menuCode,userId);
        if(count == 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();// 回滚
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return  appResponse;
    }

    /**
     * 新增菜单
     */
    public AppResponse saveMenu(Menu menu) {
        AppResponse appResponse = AppResponse.success("新增成功！");
        // 新增菜单
        int count = menuDao.saveMenu(menu);
        if(0 == count) {
            appResponse = AppResponse.bizError("新增失败，请重试！");
        }
        return appResponse;
    }
    /**
     * 功能：修改菜单
     */
    public AppResponse updateMenu(Menu menu) {
        AppResponse appResponse = AppResponse.success("修改成功！");
        int count = menuDao.updateMenu(menu);
        if(0 == count) {
            appResponse = AppResponse.bizError("修改失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 功能：查询用户菜单(角色)
     */
    public AppResponse listMenusByRole(String userId){
       int count = userDao.getRole(userId);
        if(count == 1){
            List<Menu> menuList = menuDao.listMenusByMan();
            return AppResponse.success("查询成功",menuList);
        }else if(count == 1){
            List<Menu> menuList = menuDao.listMenus();
            return AppResponse.success("查询成功",menuList);
        }
        return AppResponse.bizError("查询失败");

    }
    /**
     * 查询菜单详情
     */
    public Menu findMenuById(String menuCode){
        return menuDao.findMenuById(menuCode);
    }
}
