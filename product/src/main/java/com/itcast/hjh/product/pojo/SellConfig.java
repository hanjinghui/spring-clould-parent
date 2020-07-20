package com.itcast.hjh.product.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.itcast.hjh.product.pojo.SellConfig")
@Data
public class SellConfig implements Serializable {
    /**
    * 主键id
    */
    @ApiModelProperty(value="主键id")
    private String configId;

    /**
    * 配置名称
    */
    @ApiModelProperty(value="配置名称")
    private String configName;

    /**
    * 配置主键key
    */
    @ApiModelProperty(value="配置主键key")
    private String configKey;

    /**
    * 配置主键value
    */
    @ApiModelProperty(value="配置主键value")
    private String configValue;

    /**
    * 配置类型（y是/n不是）
    */
    @ApiModelProperty(value="配置类型（y是/n不是）")
    private String configType;

    /**
    * 创建人
    */
    @ApiModelProperty(value="创建人")
    private String createBy;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 修改人
    */
    @ApiModelProperty(value="修改人")
    private String updateBy;

    /**
    * 修改时间
    */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}