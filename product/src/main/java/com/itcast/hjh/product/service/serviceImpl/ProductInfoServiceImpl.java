package com.itcast.hjh.product.service.serviceImpl;

import com.itcast.hjh.base.enums.ProductEnum;
import com.itcast.hjh.product.dao.ProductCategoryMapper;
import com.itcast.hjh.product.pojo.ProductCategory;
import com.itcast.hjh.product.pojo.ProductCategoryExample;
import com.itcast.hjh.product.productVo.ProductInfoVo;
import com.itcast.hjh.product.productVo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.itcast.hjh.product.dao.ProductInfoMapper;
import com.itcast.hjh.product.pojo.ProductInfoExample;
import com.itcast.hjh.product.pojo.ProductInfo;
import com.itcast.hjh.product.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService{

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
    public int updateByExampleSelective(ProductInfo record,ProductInfoExample example) {
        return productInfoMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProductInfo record,ProductInfoExample example) {
        return productInfoMapper.updateByExample(record,example);
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
     * @return
     */
    @Override
    public List<ProductVO> selectProductListByCategory() {

        //先查找所有的类目
        ProductInfoExample productInfoExample = new ProductInfoExample();
        ProductInfoExample.Criteria criteria = productInfoExample.createCriteria();
        criteria.andCategoryTypeEqualTo(ProductEnum.UP.getCode());
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
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productVO.setProductInfoVoList(productInfoVoList);
            productVOList.add(productVO);
        }
        return productVOList;
    }

}
