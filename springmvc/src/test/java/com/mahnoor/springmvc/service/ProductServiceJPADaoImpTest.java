package com.mahnoor.springmvc.service;

import com.mahnoor.springmvc.domain.Product;
import com.mahnoor.springmvc.services.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.instanceOf;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@ActiveProfiles("jpadao")
public class ProductServiceJPADaoImpTest {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void listAllTest() {
        List<Product> productList=productService.listAll();
        assert productList.size() == 5;
    }

    @Test
    public void getProductTest() {
        instanceOf(productService.getById(1).getClass()).matches(Product.class);
    }

    @Test
    public void deleteProductTest() {
        productService.delete(1);
        List<Product> productList=productService.listAll();
        assert productList.size() == 4;


    }

    @Test
    public void saveOrUpdateProductTest() {
        Product product=productService.getById(2);
        product.setDescription("newUpdatedDesc");
        productService.saveOrUpdate(product);

        assert product.getDescription().equals(productService.getById(2).getDescription());

    }
}
