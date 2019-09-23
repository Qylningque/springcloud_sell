package com.linco.product.controller;

import com.linco.product.common.DecreaseStockInput;
import com.linco.product.dataobject.ProductCategory;
import com.linco.product.dataobject.ProductInfo;
import com.linco.product.service.ProductCategoryService;
import com.linco.product.service.ProductService;
import com.linco.product.utils.ResultVOUtil;
import com.linco.product.vo.ProductInfoVO;
import com.linco.product.vo.ProductVO;
import com.linco.product.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname: ProductController
 * @description: 商品Controller
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 12:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCategoryService categoryService;

    @Autowired
    private ProductService productService;

    /**
     * 1.查询所有在架的商品列表
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     * @return
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list(){
        // 1.查询所有在架的商品列表
        List<ProductInfo> upProductList = productService.findUpAll();
        //2.获取类目type列表
        List<Integer> categoryTypeList = upProductList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        //3.查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : categoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : upProductList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表（供外部服务调用）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productService.decreaseStock(decreaseStockInputList);
    }
}
