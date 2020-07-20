package com.itcast.hjh.product.controller;

import com.itcast.hjh.common.util.SendEmailUtil;
import com.itcast.hjh.product.productVo.ProductVO;
import com.itcast.hjh.product.service.ProductInfoService;
import com.itcast.hjh.common.util.wrapper.WrapMapper;
import com.itcast.hjh.common.util.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@Api(value = "商品管理")
@RestController
@RequestMapping("/product/test")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 根据类目查找在家商品
     * @return
     */
    @GetMapping("/list")
    @ApiOperation(httpMethod = "GET",value = "根据类目查找在家商品")
    public Wrapper productList(){

        List<ProductVO> productInfos = productInfoService.selectProductListByCategory();

        return  WrapMapper.wrap(Wrapper.SUCCESS_CODE,"查询成功！",productInfos);
    }

    /**
     * 修改邮件配置文件
     * @param fileName
     * @return
     */
    @GetMapping("/selectProperties")
    @ApiOperation(httpMethod = "POST",value = "修改邮件配置文件")
    public Wrapper selectProperties(String fileName){

        Wrapper  wrapper = productInfoService.selectProperties(fileName);
        return wrapper;
    }


    /**
     * 修改邮件配置文件
     * @param map
     * @return
     */
    @PostMapping("/editProperties")
    @ApiOperation(httpMethod = "POST",value = "修改邮件配置文件")
    public Wrapper editProperties(String fileName,@RequestBody Map<String,String> map){

        Wrapper  wrapper = productInfoService.editProperties(fileName,map);
        return wrapper;
    }

    @PostMapping("/sendEmail")
    public Wrapper sendEmail(@RequestBody List<String> emails){
        try {
            SendEmailUtil.sentEmail(emails);
            return WrapMapper.wrap(Wrapper.SUCCESS_CODE,"发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return WrapMapper.wrap(Wrapper.ERROR_CODE,"发送失败！");
        }
    }
}
