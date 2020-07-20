package com.itcast.hjh.product.service;

import java.util.List;
import com.itcast.hjh.product.pojo.SellConfigExample;
import com.itcast.hjh.product.pojo.SellConfig;
public interface SellConfigService{


    long countByExample(SellConfigExample example);

    int deleteByExample(SellConfigExample example);

    int deleteByPrimaryKey(String configId);

    int insert(SellConfig record);

    int insertSelective(SellConfig record);

    List<SellConfig> selectByExample(SellConfigExample example);

    SellConfig selectByPrimaryKey(String configId);

    int updateByExampleSelective(SellConfig record,SellConfigExample example);

    int updateByExample(SellConfig record,SellConfigExample example);

    int updateByPrimaryKeySelective(SellConfig record);

    int updateByPrimaryKey(SellConfig record);

}
