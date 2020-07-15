package com.itcast.hjh.product.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.itcast.hjh.product.pojo.OrderMaster;
import com.itcast.hjh.product.dao.OrderMasterMapper;
import java.util.List;
import com.itcast.hjh.product.pojo.OrderMasterExample;
import com.itcast.hjh.product.service.OrderMasterService;
@Service
public class OrderMasterServiceImpl implements OrderMasterService{

    @Resource
    private OrderMasterMapper orderMasterMapper;

    @Override
    public long countByExample(OrderMasterExample example) {
        return orderMasterMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderMasterExample example) {
        return orderMasterMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String orderId) {
        return orderMasterMapper.deleteByPrimaryKey(orderId);
    }

    @Override
    public int insert(OrderMaster record) {
        return orderMasterMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderMaster record) {
        return orderMasterMapper.insertSelective(record);
    }

    @Override
    public List<OrderMaster> selectByExample(OrderMasterExample example) {
        return orderMasterMapper.selectByExample(example);
    }

    @Override
    public OrderMaster selectByPrimaryKey(String orderId) {
        return orderMasterMapper.selectByPrimaryKey(orderId);
    }

    @Override
    public int updateByExampleSelective(OrderMaster record,OrderMasterExample example) {
        return orderMasterMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(OrderMaster record,OrderMasterExample example) {
        return orderMasterMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderMaster record) {
        return orderMasterMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderMaster record) {
        return orderMasterMapper.updateByPrimaryKey(record);
    }

}
