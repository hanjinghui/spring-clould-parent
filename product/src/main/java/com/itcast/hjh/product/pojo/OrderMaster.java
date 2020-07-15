package com.itcast.hjh.product.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.itcast.hjh.product.pojo.OrderMaster")
@Data
public class OrderMaster implements Serializable {
    @ApiModelProperty(value="null")
    private String orderId;

    /**
    * 买家名字
    */
    @ApiModelProperty(value="买家名字")
    private String buyerName;

    /**
    * 买家电话
    */
    @ApiModelProperty(value="买家电话")
    private String buyerPhone;

    /**
    * 买家地址
    */
    @ApiModelProperty(value="买家地址")
    private String buyerAddress;

    /**
    * 买家微信openid
    */
    @ApiModelProperty(value="买家微信openid")
    private String buyerOpenid;

    /**
    * 订单总金额
    */
    @ApiModelProperty(value="订单总金额")
    private BigDecimal orderAmount;

    /**
    * 订单状态，默认0新下单
    */
    @ApiModelProperty(value="订单状态，默认0新下单")
    private Byte orderStatus;

    /**
    * 支付状态，默认0未支付
    */
    @ApiModelProperty(value="支付状态，默认0未支付")
    private Byte payStatus;

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