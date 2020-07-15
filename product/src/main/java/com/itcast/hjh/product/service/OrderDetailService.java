package com.itcast.hjh.product.service;

import com.itcast.hjh.product.pojo.OrderDetail;
import java.util.List;
import com.itcast.hjh.product.pojo.OrderDetailExample;
public interface OrderDetailService{


    long countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(String detailId);

    int updateByExampleSelective(OrderDetail record,OrderDetailExample example);

    int updateByExample(OrderDetail record,OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

}
