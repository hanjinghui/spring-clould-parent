package com.itcast.hjh.product.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.itcast.hjh.product.pojo.ProductCategory")
@Data
public class ProductCategory implements Serializable {
    @ApiModelProperty(value="null")
    private Integer categoryId;

    /**
    * 类目名字
    */
    @ApiModelProperty(value="类目名字")
    private String categoryName;

    /**
    * 类目编号
    */
    @ApiModelProperty(value="类目编号")
    private Integer categoryType;

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