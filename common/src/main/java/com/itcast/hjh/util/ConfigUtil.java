package com.itcast.hjh.util;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 项目参数工具类
 * 
 * 
 */
@PropertySource(value = {"classpath:config.properties"})
@ConfigurationProperties(prefix = "config")
@Component
@Data
public class ConfigUtil{

	/**
	 * 超级管理员角色code
	 */
	private String cjgly;
	/**
	 * 组织管理员角色code
	 */
	private String zzgly;
	/**
	 * user图像路径1
 	 */
	private String userImgRoad;

	//管理员
	private String glygw;
	//护士
	private String hsgw;
	//医生
	private String ysgw;
    /**
     *  上传相对路径
     */
    public String remotePath;
	private String morningwork;
	private String aftergwork;
	private String nightwork;


}
