package com.linco.product.repository;

import com.linco.product.dataobject.ProductInfo;
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
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findAllByProductStatus() throws Exception{
        List<ProductInfo> list = productInfoRepository.findAllByProductStatus(0);
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findByProductIdIn() throws Exception{
        List<ProductInfo> result = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(result.size()>0);
    }
}