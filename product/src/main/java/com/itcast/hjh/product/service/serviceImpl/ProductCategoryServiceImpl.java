package com.itcast.hjh.product.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.itcast.hjh.product.dao.ProductCategoryMapper;
import com.itcast.hjh.product.pojo.ProductCategoryExample;
import com.itcast.hjh.product.pojo.ProductCategory;
import com.itcast.hjh.product.service.ProductCategoryService;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public long countByExample(ProductCategoryExample example) {
        return productCategoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductCategoryExample example) {
        return productCategoryMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return productCategoryMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public int insert(ProductCategory record) {
        return productCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductCategory record) {
        return productCategoryMapper.insertSelective(record);
    }

    @Override
    public List<ProductCategory> selectByExample(ProductCategoryExample example) {
        return productCategoryMapper.selectByExample(example);
    }

    @Override
    public ProductCategory selectByPrimaryKey(Integer categoryId) {
        return productCategoryMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    public int updateByExampleSelective(ProductCategory record,ProductCategoryExample example) {
        return productCategoryMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProductCategory record,ProductCategoryExample example) {
        return productCategoryMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductCategory record) {
        return productCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductCategory record) {
        return productCategoryMapper.updateByPrimaryKey(record);
    }

}
