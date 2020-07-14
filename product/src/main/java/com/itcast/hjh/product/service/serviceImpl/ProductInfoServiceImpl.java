package com.itcast.hjh.product.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.itcast.hjh.product.dao.ProductInfoMapper;
import com.itcast.hjh.product.pojo.ProductInfoExample;
import com.itcast.hjh.product.pojo.ProductInfo;
import com.itcast.hjh.product.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public long countByExample(ProductInfoExample example) {
        return productInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductInfoExample example) {
        return productInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String productId) {
        return productInfoMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(ProductInfo record) {
        return productInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductInfo record) {
        return productInfoMapper.insertSelective(record);
    }

    @Override
    public List<ProductInfo> selectByExample(ProductInfoExample example) {
        return productInfoMapper.selectByExample(example);
    }

    @Override
    public ProductInfo selectByPrimaryKey(String productId) {
        return productInfoMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByExampleSelective(ProductInfo record,ProductInfoExample example) {
        return productInfoMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProductInfo record,ProductInfoExample example) {
        return productInfoMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKey(record);
    }

}
