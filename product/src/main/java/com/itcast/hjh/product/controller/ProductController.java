package com.itcast.hjh.product.controller;

import com.itcast.hjh.product.pojo.ProductInfo;
import com.itcast.hjh.product.pojo.ProductInfoExample;
import com.itcast.hjh.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("product/")
@RestController
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping("/list")
    public List productList(){

        ProductInfoExample productInfoExample = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = productInfoExample.createCriteria();
        criteria.andCategoryTypeEqualTo(1);
        List<ProductInfo> productInfos = productInfoService.selectByExample(productInfoExample);
        return  productInfos;
    }

}
