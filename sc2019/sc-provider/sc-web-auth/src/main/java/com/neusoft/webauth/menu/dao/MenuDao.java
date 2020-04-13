package com.neusoft.webauth.menu.dao;

import com.neusoft.webauth.menu.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description 菜单管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public interface MenuDao {

    /**
     * 查询全部菜单
     * @return 菜单集合
     */
    List<Menu> listMenus();
    /**
     * 删除菜单
     * @return
     */
    int deleteMenu(@Param("menuCode") String menuCode,@Param("userId")String userId);
    /**
     * 新增菜单
     * @param menu 菜单信息
     * @return
     */
    int saveMenu(Menu menu);
    /**
     * 修改菜单
     * @param menu 菜单信息
     * @return
     */
    int updateMenu(Menu menu);
    /**
     * 查询店长能看到的菜单列表
     *  @return 菜单代码集合
     */
    List<Menu> listMenusByMan();
    /**
     * 获取用户菜单信息
     * @param menu
     * @return
     */
    List<Menu> listUserMenus(Menu menu);

    /**
     * 删除角色关联的菜单按钮
     * @param menu 菜单信息
     * @return
     */
    int deleteRoleMenuBtnByMenu(Menu menu);
    /**
     * 查询菜单详情
     */
    Menu findMenuById(@Param("menuCode")String menuCode);
}
