package com.itcast.hjh.product.productVo;

import com.itcast.hjh.product.mapper.SellConfigMapper;
import com.itcast.hjh.product.pojo.SellConfig;
import com.itcast.hjh.product.pojo.SellConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ConfigProterties {

    public static Map<String,String> configMap =  new HashMap<String,String>();

    @Autowired
    private SellConfigMapper sellConfigMapper;

    @PostConstruct
    public void init(){

        HashMap<String, String> map = new HashMap<>();
        SellConfigExample sellConfigExample = new SellConfigExample();
        SellConfigExample.Criteria criteria = sellConfigExample.createCriteria();
        criteria.andConfigTypeEqualTo("y");
        List<SellConfig> sellConfigs = sellConfigMapper.selectByExample(sellConfigExample);

        configMap = sellConfigs.stream().collect(Collectors.toMap(SellConfig::getConfigKey, SellConfig::getConfigValue));
        System.out.println("缓存加载了。。。。。。。。。。。。。");
    }

    @Scheduled(cron = "0 0 0/2 * * ?")
    public void testOne() {
        //每2小时执行一次缓存
        init();
    }
}
