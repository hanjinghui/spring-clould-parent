package com.itcast.hjh.product.controller;

import com.itcast.hjh.base.enums.ProductEnum;
import com.itcast.hjh.core.mybatis.BaseEntity;
import com.itcast.hjh.product.pojo.ProductInfo;
import com.itcast.hjh.product.pojo.ProductInfoExample;
import com.itcast.hjh.product.productVo.ProductVO;
import com.itcast.hjh.product.service.ProductInfoService;
import com.itcast.hjh.util.wrapper.WrapMapper;
import com.itcast.hjh.util.wrapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("product/")
@RestController
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 根据类目查找在家商品
     * @return
     */
    @GetMapping("/list")
    public Wrapper productList(){

        List<ProductVO> productInfos = productInfoService.selectProductListByCategory();

        return  WrapMapper.wrap(Wrapper.SUCCESS_CODE,"查询成功！",productInfos);
    }

}
