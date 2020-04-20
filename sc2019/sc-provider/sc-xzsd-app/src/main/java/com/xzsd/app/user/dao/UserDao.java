package com.xzsd.app.user.dao;



import com.xzsd.app.customer.entity.CustomerInfo;
import com.xzsd.app.user.entity.UserInfo;
import com.xzsd.app.user.entity.UserSettingDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description 用户管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
public interface UserDao {
    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int saveUser(UserInfo userInfo);

    /**
     * 获取用户信息
     * @param userCode 用户代码
     * @return 用户信息
     */
    UserInfo getUserById(@Param("userCode") String userCode);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsersByPage(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param userSettingDTO 选中的用户信息
     * @return
     */
    int deleteUser(UserSettingDTO userSettingDTO);

    /**
     * 修改密码
     * @param userInfo 用户信息
     * @return
     */
    int updateUserPwd(UserInfo userInfo);
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);
    /**
     * 获取该用户角色
     */
    int getRole(@Param("userId") String userId);
    /**
     * 新增客户
     */
    int saveCustomer(CustomerInfo customerInfo);
    /**
     * 查看账号是否已存在
     */
    int countCustomerAcct(CustomerInfo customerInfo);
}
