package com.itcast.hjh.product.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com.itcast.hjh.product.pojo.ProductInfo")
@Data
public class ProductInfo implements Serializable {
    @ApiModelProperty(value = "null")
    private String productId;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String productName;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private BigDecimal productPrice;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Integer productStock;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String productDescription;

    /**
     * 小图
     */
    @ApiModelProperty(value = "小图")
    private String productIcon;

    /**
     * 是否上架（1上架/2下架）
     */
    @ApiModelProperty(value = "是否上架（1上架/2下架）")
    private String productStatus;

    /**
     * 类目编号
     */
    @ApiModelProperty(value = "类目编号")
    private Integer categoryType;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}