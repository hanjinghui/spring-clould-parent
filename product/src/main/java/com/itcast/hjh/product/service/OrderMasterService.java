package com.itcast.hjh.product.service;

import com.itcast.hjh.product.pojo.OrderMaster;
import java.util.List;
import com.itcast.hjh.product.pojo.OrderMasterExample;
public interface OrderMasterService{


    long countByExample(OrderMasterExample example);

    int deleteByExample(OrderMasterExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    int insertSelective(OrderMaster record);

    List<OrderMaster> selectByExample(OrderMasterExample example);

    OrderMaster selectByPrimaryKey(String orderId);

    int updateByExampleSelective(OrderMaster record,OrderMasterExample example);

    int updateByExample(OrderMaster record,OrderMasterExample example);

    int updateByPrimaryKeySelective(OrderMaster record);

    int updateByPrimaryKey(OrderMaster record);

}
