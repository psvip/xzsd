
package com.neusoft.webauth.menu.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.webauth.base.constant.GlobalConstant;
import com.neusoft.webauth.base.entity.Tree;
import com.neusoft.webauth.menu.entity.Menu;
import com.neusoft.webauth.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;


/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */

@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Resource
    private MenuService menuService;
     /**
      *查询菜单列表
      *
     */
    @RequestMapping(value = "listMenus")
    public AppResponse listMenus( ) {
        try {
            return menuService.listMenus();
        } catch (Exception e) {
            logger.error("菜单获取异常", e);
            throw new ScServerException("查询错误，请重试");
        }
    }
/**
     * 部门：南京软件研发中心
     * 功能：删除菜单
     */

   @RequestMapping(value = "deleteMenu")
    public AppResponse deleteMenu(String menuCode) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menuService.deleteMenu(menuCode,userId);
            return AppResponse.success("菜单删除成功");
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            return AppResponse.notFound("删除失败");
        }
    }
    /**
     *  新增菜单
    *
     */
    @RequestMapping(value = "saveMenu")
    public AppResponse saveMenu(@Valid Menu menu) {
        try {
            String userId =  SecurityUtils.getCurrentUserId();
            menu.setCreateBy(userId);
            return menuService.saveMenu(menu);
        } catch (Exception e) {
            logger.error("菜单新增异常", e);
            throw new ScServerException("菜单新增失败，请重试！");
        }
    }
    /**
     * 功能：修改菜单
     */
    @RequestMapping(value = "updateMenu")
    public AppResponse updateMenu(@Valid Menu menu) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            menu.setLastModifiedBy(userId);
            return menuService.updateMenu(menu);
        } catch (Exception e) {
            logger.error("菜单修改异常", e);
            throw new ScServerException("菜单修改失败，请重试");
        }
    }


/**
     * 根据角色代码获取菜单
     *
     * @param
     * @return
     */

    @RequestMapping(value = "listMenusByRole")
    public AppResponse listMenusByRole() {
        try {
            // 用户code
            String userId =  SecurityUtils.getCurrentUserId();
          return menuService.listMenusByRole(userId);
        } catch (Exception e) {
            logger.error("获取菜单失败", e);
            throw new ScServerException("获取菜单失败，请重试");
        }
    }
    /**
     * 查询菜单详情
     */
    @RequestMapping("findMenuById")
    public AppResponse findMenuById(String menuCode){
        Menu menu;
        try {
            menu = menuService.findMenuById(menuCode);
        } catch (Exception e) {
            logger.error("菜单查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (menu == null) {
            return AppResponse.notFound("无查询结果");
        }
        return AppResponse.success("查询成功", menu);
    }
}

