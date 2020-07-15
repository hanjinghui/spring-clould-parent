package com.itcast.hjh.product.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.itcast.hjh.product.pojo.OrderDetail;
import java.util.List;
import com.itcast.hjh.product.pojo.OrderDetailExample;
import com.itcast.hjh.product.dao.OrderDetailMapper;
import com.itcast.hjh.product.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public long countByExample(OrderDetailExample example) {
        return orderDetailMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderDetailExample example) {
        return orderDetailMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String detailId) {
        return orderDetailMapper.deleteByPrimaryKey(detailId);
    }

    @Override
    public int insert(OrderDetail record) {
        return orderDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderDetail record) {
        return orderDetailMapper.insertSelective(record);
    }

    @Override
    public List<OrderDetail> selectByExample(OrderDetailExample example) {
        return orderDetailMapper.selectByExample(example);
    }

    @Override
    public OrderDetail selectByPrimaryKey(String detailId) {
        return orderDetailMapper.selectByPrimaryKey(detailId);
    }

    @Override
    public int updateByExampleSelective(OrderDetail record,OrderDetailExample example) {
        return orderDetailMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(OrderDetail record,OrderDetailExample example) {
        return orderDetailMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKey(record);
    }

}
