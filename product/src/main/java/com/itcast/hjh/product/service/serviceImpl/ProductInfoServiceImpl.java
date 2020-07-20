package com.itcast.hjh.product.service.serviceImpl;

import com.itcast.hjh.common.base.enums.ProductEnum;
import com.itcast.hjh.common.util.wrapper.WrapMapper;
import com.itcast.hjh.common.util.wrapper.Wrapper;
import com.itcast.hjh.product.mapper.ProductCategoryMapper;
import com.itcast.hjh.product.pojo.ProductCategory;
import com.itcast.hjh.product.pojo.ProductCategoryExample;
import com.itcast.hjh.product.productVo.ConfigProterties;
import com.itcast.hjh.product.productVo.ProductInfoVo;
import com.itcast.hjh.product.productVo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import com.itcast.hjh.product.mapper.ProductInfoMapper;
import com.itcast.hjh.product.pojo.ProductInfoExample;
import com.itcast.hjh.product.pojo.ProductInfo;
import com.itcast.hjh.product.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ConfigProterties configProterties;

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public long countByExample(ProductInfoExample example) {
        return productInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductInfoExample example) {
        return productInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String productId) {
        return productInfoMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int insert(ProductInfo record) {
        return productInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductInfo record) {
        return productInfoMapper.insertSelective(record);
    }

    @Override
    public List<ProductInfo> selectByExample(ProductInfoExample example) {
        return productInfoMapper.selectByExample(example);
    }

    @Override
    public ProductInfo selectByPrimaryKey(String productId) {
        return productInfoMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int updateByExampleSelective(ProductInfo record, ProductInfoExample example) {
        return productInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ProductInfo record, ProductInfoExample example) {
        return productInfoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据类目查找上线的商品
     *
     * @return
     */
    @Override
    public  List<ProductVO> selectProductListByCategory() {

        //先查找所有的类目
        ProductInfoExample productInfoExample = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = productInfoExample.createCriteria();
        criteria.andProductStatusEqualTo(ProductEnum.UP.getCode());
        List<ProductInfo> productInfos = productInfoMapper.selectByExample(productInfoExample);

        //查找所有的类目code
        List<Integer> categoryTypeList = productInfos.stream().map(productInfo -> productInfo.getCategoryType()).collect(Collectors.toList());
        //从数据库中查询类目集合
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria1 = productCategoryExample.createCriteria();
        criteria1.andCategoryTypeIn(categoryTypeList);
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(productCategoryExample);

        //构建数据
        ArrayList<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            ArrayList<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);
            productVOList.add(productVO);
        }

        Map<String,String> map = ConfigProterties.configMap;
        System.out.println(map.get("port")+".................");
        return productVOList;
    }

    /**
     * 修改配置文件
     * @param map
     * @return
     */
    @Override
    public Wrapper editProperties(String fileName,Map<String,String> map) {
        //获取文件
        String filePath = Profile.class.getClassLoader().getResource(fileName).getFile();
        try {
            filePath =  java.net.URLDecoder.decode(filePath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("propertiesPath:" + filePath);
        Properties props = new Properties();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 从输入流中读取属性列表（键和元素对）
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            props.load(br);
            br.close();
            // 写入属性文件
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            // 清空旧的文件
            // props.clear();
            for (String key : map.keySet())
                props.setProperty(key, map.get(key));
            props.store(bw, "改变数据");
            System.out.println(props.getProperty("url"));

            bw.close();
            return WrapMapper.wrap(Wrapper.SUCCESS_CODE,"修改成功！");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Visit " + filePath + " for updating " + "" + " value error");
            return WrapMapper.wrap(Wrapper.ERROR_CODE,"修改失败！");
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查看配置文件
     * @param fileName
     * @return
     */
    @Override
    public Wrapper selectProperties(String fileName) {

        //获取文件
        String filePath = Profile.class.getClassLoader().getResource(fileName).getFile();
        try {
            filePath =  java.net.URLDecoder.decode(filePath, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("propertiesPath:" + filePath);
        Properties props = new Properties();
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 从输入流中读取属性列表（键和元素对）
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            props.load(br);
            br.close();

            HashMap<String, Object> map = new HashMap<>();
            for(Object name:props.keySet().toArray()){
                map.put(name.toString(), props.getProperty(name.toString()));
            }
            return WrapMapper.wrap(Wrapper.SUCCESS_CODE,"查询成功！",map);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Visit " + filePath + " for updating " + "" + " value error");
            return WrapMapper.wrap(Wrapper.ERROR_CODE,"修改失败！");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

