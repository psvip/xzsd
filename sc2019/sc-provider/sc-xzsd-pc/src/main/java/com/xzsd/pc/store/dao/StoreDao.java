package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.AddressInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店
 */
public interface StoreDao {
    /**
     * 校验门店是否存在
     * @param storeInfo
     * @return
     */
    int countStoreId(StoreInfo storeInfo);
    /**
     * 新增门店
     */
    int saveStore(StoreInfo storeInfo);
    /**
     * 查询门店详情
     */
    StoreInfo findStoreById(@Param("storeCode") String storeCode);
    /**
     * 修改门店信息
     */
    int updateStoreById(StoreInfo storeInfo);
    /**
     * 查询门店列表（管理员）
     * @param
     * @return
     */
    List<StoreInfo> listStore(StoreInfo storeInfo);
    /**
     * 查询门店列表（店长）
     */
    List<StoreInfo> listStoreByManager(StoreInfo storeInfo);
    /**
     * 删除门店
     */
    int deleteStore(@Param("listStoreCode") List<String> listStoreCode, @Param("userId") String userId);
    /**
     * 省市区下拉查询
     */
    List<AddressInfo> findStoreAdd(@Param("parentCode")String parentCode);
}
