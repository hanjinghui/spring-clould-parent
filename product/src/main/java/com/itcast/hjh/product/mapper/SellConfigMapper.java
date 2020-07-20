package com.itcast.hjh.product.mapper;

import com.itcast.hjh.product.pojo.SellConfig;
import com.itcast.hjh.product.pojo.SellConfigExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface SellConfigMapper {
    long countByExample(SellConfigExample example);

    int deleteByExample(SellConfigExample example);

    int deleteByPrimaryKey(String configId);

    int insert(SellConfig record);

    int insertSelective(SellConfig record);

    List<SellConfig> selectByExample(SellConfigExample example);

    SellConfig selectByPrimaryKey(String configId);

    int updateByExampleSelective(@Param("record") SellConfig record, @Param("example") SellConfigExample example);

    int updateByExample(@Param("record") SellConfig record, @Param("example") SellConfigExample example);

    int updateByPrimaryKeySelective(SellConfig record);

    int updateByPrimaryKey(SellConfig record);
}