package com.mahnoor.springmvc.bootstrap;

import com.mahnoor.springmvc.domain.*;
import com.mahnoor.springmvc.enums.OrderStatus;
import com.mahnoor.springmvc.services.CustomerService;
import com.mahnoor.springmvc.services.OrderService;
import com.mahnoor.springmvc.services.ProductService;
import com.mahnoor.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProductService productService;
    private CustomerService customerService;
    private UserService userService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    private OrderService orderService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadAllProducts();
        loadAllCustomers();
        loadCarts();
        loadOrderHistory();


    }

    private void loadOrderHistory() {
        List<User> allUsers=userService.listAll();
        List<Product> products=productService.listAll();


        allUsers.forEach(user -> {

            Orders order=new Orders();
            order.setCustomer(user.getCustomer());
            order.setOrderStatus(OrderStatus.SHIPPED);

            products.forEach(product -> {
                OrderDetail orderDetail=new OrderDetail();
                orderDetail.setMyOrder(order);
                orderDetail.setProduct(product);
                orderDetail.setQuantity(2);
                order.addToOrderDetails(orderDetail);
            });

        });

    }

    private void loadCarts() {
        List<User> allUsers=userService.listAll();
        List<Product> products=productService.listAll();


        allUsers.forEach(user -> {

            Cart cart=new Cart();
            user.setCart(cart);

            CartDetail cartDetail=new CartDetail();
            cartDetail.setProduct(products.get(0));
            cartDetail.setQuantity(1);
            user.getCart().addCartDetailList(cartDetail);

            userService.saveOrUpdate(user);

        });



    }

    private void loadAllCustomers() {
        User user=new User();
        user.setUsername("mabbasi");
        user.setPassword("helloWorld");
        Customer customer= new Customer("Mahnoor1","Ababsi",
                "mabbasi@xavor.com","0909",new Address(), new Address());
        user.setCustomer(customer);
        userService.saveOrUpdate(user);


        user=new User();
        user.setUsername("mabbasi2");
        user.setPassword("helloWorld");
        customer= new Customer("Mahnoor2","Ababsi",
                "mabbasi@xavor.com","0909",new Address(), new Address());

        user.setCustomer(customer);
        userService.saveOrUpdate(user);


        user=new User();
        user.setUsername("mabbasi3");
        user.setPassword("helloWorld");
        customer= new Customer("Mahnoor3","Ababsi",
                "mabbasi@xavor.com", "0909",new Address(), new Address());
        user.setCustomer(customer);
        userService.saveOrUpdate(user);

        user=new User();
        user.setUsername("mabbasi4");
        user.setPassword("helloWorld");
        customer= new Customer("Mahnoor4","Ababsi",
                "mabbasi@xavor.com", "0909",new Address(), new Address());
        user.setCustomer(customer);
        userService.saveOrUpdate(user);

        user=new User();
        user.setUsername("mabbasi5");
        user.setPassword("helloWorld");
        customer= new Customer("Mahnoor5","Ababsi",
                "mabbasi@xavor.com","0909",new Address(), new Address());
        user.setCustomer(customer);
        userService.saveOrUpdate(user);

        user=new User();
        user.setUsername("mabbasi6");
        user.setPassword("helloWorld");
        customer= new Customer("Mahnoor6","Ababsi",
                "mabbasi@xavor.com","0909",new Address(), new Address());
        user.setCustomer(customer);
        userService.saveOrUpdate(user);

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
