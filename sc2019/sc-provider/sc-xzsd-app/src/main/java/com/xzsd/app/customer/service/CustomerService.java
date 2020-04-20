package com.xzsd.app.customer.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.customer.dao.CustomerDao;
import com.xzsd.app.customer.entity.CustomerInfo;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.manager.dao.ManagerDao;
import com.xzsd.app.manager.entity.ManagerInfo;
import com.xzsd.app.user.dao.UserDao;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CustomerService {
    @Resource
    CustomerDao customerDao;
    @Resource
    ManagerDao managerDao;
    @Resource
    UserDao userDao;
    @Resource
    DriverDao driverDao;
    /**
     * 新增用户
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveCustomer(CustomerInfo customerInfo){
        //校验客户账号是否存在
        int countAcct = userDao.countCustomerAcct(customerInfo);
        if(0 != countAcct){
            return AppResponse.bizError("账号已存在，请重新输入！");
        }
        String pwd = PasswordUtils.generatePassword(customerInfo.getPassword());
        customerInfo.setIsDeleted(0);
        customerInfo.setPassword(pwd);
        int count = customerDao.saveCustomer(customerInfo);
        int countCustomer = userDao.saveCustomer(customerInfo);
        if(count == 0 || countCustomer == 0){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return  AppResponse.success("新增成功",customerInfo);
    }
    /**
     * 查询个人信息（1店长2客户3司机）
     */
    public AppResponse customerInformation(String userCode){
        int role = userDao.getRole(userCode);
        if(role == 2){
            CustomerInfo customerInfo = customerDao.customerInformation(userCode);
        }
        else if(role == 1){
            ManagerInfo managerInfo = managerDao.managerInformation(userCode);
        }
        else if(role ==3){
            DriverInfo driverInfo = driverDao.driverInformation(userCode);
        }
       return AppResponse.success("查询成功");
    }


}
