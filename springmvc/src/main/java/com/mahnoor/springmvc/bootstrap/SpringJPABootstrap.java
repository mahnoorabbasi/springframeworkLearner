package com.mahnoor.springmvc.bootstrap;

import com.mahnoor.springmvc.domain.Customer;
import com.mahnoor.springmvc.domain.Product;
import com.mahnoor.springmvc.services.CustomerService;
import com.mahnoor.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProductService productService;
    private CustomerService customerService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadAllProducts();
        loadAllCustomers();

    }

    private void loadAllCustomers() {
        Customer customer= new Customer("Mahnoor1","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
       customerService.saveOrUpdate(customer);
        customer= new Customer("Mahnoor2","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        customerService.saveOrUpdate(customer);
        customer= new Customer("Mahnoor3","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        customerService.saveOrUpdate(customer);
        customer= new Customer("Mahnoor4","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        customerService.saveOrUpdate(customer);
        customer= new Customer("Mahnoor5","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        customerService.saveOrUpdate(customer);
        customer= new Customer("Mahnoor6","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        customerService.saveOrUpdate(customer);

    }

    private void loadAllProducts() {
        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");
        productService.saveOrUpdate(product1);

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");
        productService.saveOrUpdate(product2);


        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");
        productService.saveOrUpdate(product3);

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");
        productService.saveOrUpdate(product4);


        Product product5 = new Product();
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");
        productService.saveOrUpdate(product5);

    }
}
