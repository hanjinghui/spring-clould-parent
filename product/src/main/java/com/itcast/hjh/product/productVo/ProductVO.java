package com.itcast.hjh.product.productVo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.itcast.hjh.product.pojo.ProductInfo;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVo> productInfoVoList;

}
