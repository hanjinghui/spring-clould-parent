package com.itcast.hjh.product.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.itcast.hjh.product.pojo.SellConfigExample;
import com.itcast.hjh.product.mapper.SellConfigMapper;
import com.itcast.hjh.product.pojo.SellConfig;
import com.itcast.hjh.product.service.SellConfigService;
@Service
public class SellConfigServiceImpl implements SellConfigService{

    @Resource
    private SellConfigMapper sellConfigMapper;

    @Override
    public long countByExample(SellConfigExample example) {
        return sellConfigMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(SellConfigExample example) {
        return sellConfigMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String configId) {
        return sellConfigMapper.deleteByPrimaryKey(configId);
    }

    @Override
    public int insert(SellConfig record) {
        return sellConfigMapper.insert(record);
    }

    @Override
    public int insertSelective(SellConfig record) {
        return sellConfigMapper.insertSelective(record);
    }

    @Override
    public List<SellConfig> selectByExample(SellConfigExample example) {
        return sellConfigMapper.selectByExample(example);
    }

    @Override
    public SellConfig selectByPrimaryKey(String configId) {
        return sellConfigMapper.selectByPrimaryKey(configId);
    }

    @Override
    public int updateByExampleSelective(SellConfig record,SellConfigExample example) {
        return sellConfigMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(SellConfig record,SellConfigExample example) {
        return sellConfigMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(SellConfig record) {
        return sellConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SellConfig record) {
        return sellConfigMapper.updateByPrimaryKey(record);
    }

}
