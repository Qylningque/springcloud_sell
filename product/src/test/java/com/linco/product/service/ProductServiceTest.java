package com.linco.product.service;

import com.linco.product.dto.CartDTO;
import com.linco.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void findList() {
        List<ProductInfo> list = productService.findList(Arrays.asList("157875227953464068", "157875196366160022"));
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO = new CartDTO("157875196366160022",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}