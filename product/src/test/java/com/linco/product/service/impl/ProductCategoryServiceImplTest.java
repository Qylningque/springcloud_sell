package com.linco.product.service.impl;

import com.linco.product.dataobject.ProductCategory;
import com.linco.product.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> list = productCategoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        Assert.assertTrue(list.size()>0);
    }
}