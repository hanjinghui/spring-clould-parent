package com.itcast.hjh.product.service;

import java.util.List;
import com.itcast.hjh.product.pojo.ProductCategoryExample;
import com.itcast.hjh.product.pojo.ProductCategory;
public interface ProductCategoryService{


    long countByExample(ProductCategoryExample example);

    int deleteByExample(ProductCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    List<ProductCategory> selectByExample(ProductCategoryExample example);

    ProductCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(ProductCategory record,ProductCategoryExample example);

    int updateByExample(ProductCategory record,ProductCategoryExample example);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);

}
