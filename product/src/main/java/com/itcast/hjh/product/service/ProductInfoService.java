package com.itcast.hjh.product.service;

import java.util.List;
import com.itcast.hjh.product.pojo.ProductInfoExample;
import com.itcast.hjh.product.pojo.ProductInfo;

public interface ProductInfoService{


    long countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(String productId);

    int updateByExampleSelective(ProductInfo record,ProductInfoExample example);

    int updateByExample(ProductInfo record,ProductInfoExample example);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

}
