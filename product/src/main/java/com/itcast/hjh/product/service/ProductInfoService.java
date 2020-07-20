package com.itcast.hjh.product.service;

import java.util.List;
import java.util.Map;

import com.itcast.hjh.common.util.wrapper.Wrapper;
import com.itcast.hjh.product.pojo.ProductInfoExample;
import com.itcast.hjh.product.pojo.ProductInfo;
import com.itcast.hjh.product.productVo.ProductVO;

public interface ProductInfoService {


    long countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(String productId);

    int updateByExampleSelective(ProductInfo record, ProductInfoExample example);

    int updateByExample(ProductInfo record, ProductInfoExample example);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

    List<ProductVO> selectProductListByCategory();

    Wrapper editProperties(String fileName,Map<String,String> map);

    Wrapper selectProperties(String fileName);
}

