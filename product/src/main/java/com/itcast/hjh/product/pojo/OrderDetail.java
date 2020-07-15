package com.itcast.hjh.product.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.itcast.hjh.product.pojo.OrderDetail")
@Data
public class OrderDetail implements Serializable {
    @ApiModelProperty(value="null")
    private String detailId;

    @ApiModelProperty(value="null")
    private String orderId;

    @ApiModelProperty(value="null")
    private String productId;

    /**
    * 商品名字
    */
    @ApiModelProperty(value="商品名字")
    private String productName;

    /**
    * 商品价格
    */
    @ApiModelProperty(value="商品价格")
    private BigDecimal productPrice;

    /**
    * 商品数量
    */
    @ApiModelProperty(value="商品数量")
    private Integer productQuantity;

    /**
    * 商品小图
    */
    @ApiModelProperty(value="商品小图")
    private String productIcon;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 更新时间
    */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}