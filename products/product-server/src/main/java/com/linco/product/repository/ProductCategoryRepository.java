package com.linco.product.repository;

import com.linco.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname: ProductCategoryRepository
 * @description: ProductCategory DAO
 * @Author: Create by qingyulin(寧缺) qylningque@outlook.com
 * @Date: 2019-09-22 13:44
 * @Version 1.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /** 获取类目type列表 */

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
