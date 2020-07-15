package com.itcast.hjh.core.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 通用bean
 */
@Data
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 2393269568666085258L;

	/**
	 * 主键
	 */
	@Id
	@ApiModelProperty(value="主键",name="id")
	@Column(name = "id")
	private String id;
	/**
	 * 创建人名称
	 */
	@Transient
	private String createUserName;

	/**
	 * 创建人ID
	 */
	@ApiModelProperty(value="创建人ID",name="createUserId")
	@Column(name = "create_user_id")
	private String createUserId;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	@ApiModelProperty(value="创建时间",name="createTime")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private String createTime;

	/**
	 * 更新人名称
	 */
	@Transient
	@ApiModelProperty(value="更新人名称",name="updateUserName")
	private String updateUserName;

	/**
	 * 更新人ID
	 */
	@Column(name = "update_user_id")
	@ApiModelProperty(value="更新人ID",name="updateUserId")
	private String updateUserId;

	/**
	 * 更新时间
	 */

	@Column(name = "update_time")
	@ApiModelProperty(value="更新时间",name="updateTime")
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	//@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private String updateTime;

	/**
	 * 删除标识  0正常；1删除
	 */
	@Column(name = "del_flag")
	@ApiModelProperty(value="删除标识  0正常；1删除",name="delFlag")
	private String delFlag;


	@Transient
	@ApiModelProperty(value="页码",name="pageNum")
	private Integer pageNum;

	@Transient
	private Integer pageSize;

	@Transient
	@ApiModelProperty(value="按什么排序",name="orderBy")
	private String orderBy;


}
