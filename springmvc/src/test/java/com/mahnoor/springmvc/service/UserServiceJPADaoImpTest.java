package com.mahnoor.springmvc.service;

import com.mahnoor.springmvc.domain.*;
import com.mahnoor.springmvc.services.ProductService;
import com.mahnoor.springmvc.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
@ActiveProfiles("jpadao")
public class UserServiceJPADaoImpTest {

    private UserService userService;
    private ProductService productService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
@Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Test
    public void saveOrUpdateTest() {
        User user=new User();
        user.setUsername("myUser");
        user.setPassword("myPassword");
        User updatedUser=userService.saveOrUpdate(user);

        assert updatedUser.getEncryptedPassword()!=null;

    }


    @Test
    public void getByIDTest() {
        User obtainedUser=userService.getById(1);
        assert obtainedUser.getUsername().equals("myUser");

    }
    @Test
    public void listAllTest() {
        List<User> allUsers=userService.listAll();
        assert allUsers.size()==1;

    }

    @Test
    public void deleteTest() {
        userService.delete(1);
        List<User> allUsers=userService.listAll();
        assert allUsers.size()==0;

    }
    @Test
    public void saveOrUpdateBidirectionalTest() {
        Customer customer = new Customer();
        customer.setFirstName("hello");
        User user=new User();
        user.setUsername("ImNewUser");
        user.setPassword("ImItsPassword");
        user.setCustomer(customer);

        User savedUser=userService.saveOrUpdate(user);

        assert savedUser.getCustomer().getId()!=null;


    }

    @Test
    public void testAddCartToUserWithCartDetails() {
        User user= new User();
        user.setUsername("mahnoor");
        user.setPassword("abbasi");
        Cart cart= new Cart();
        user.setCart(cart);

        List<Product> productList=productService.listAll();

        CartDetail cartDetail1=new CartDetail();
        cartDetail1.setProduct(productList.get(1));
        user.getCart().addCartDetailList(cartDetail1);


        cartDetail1=new CartDetail();
        cartDetail1.setProduct(productList.get(2));
        user.getCart().addCartDetailList(cartDetail1);


        User savedUser=userService.saveOrUpdate(user);


        assert savedUser.getId()!=null;
        assert savedUser.getVersion()!=null;
        assert savedUser.getCart().getId()!=null;
        assert savedUser.getCart()!=null;
        assert savedUser.getCart().getCartDetailList().size()==2;



    }


    @Test
    public void testAddAndRemoveCartToUserWithCartDetails() {
        User user=new User();
        user.setUsername("mahnoor");
        user.setPassword("abbasi");


        Cart cart=new Cart();
        user.setCart(cart);

        List<Product> productList=productService.listAll();

        CartDetail cartDetail1=new CartDetail();
        cartDetail1.setProduct(productList.get(1));
        user.getCart().addCartDetailList(cartDetail1);


        cartDetail1=new CartDetail();
        cartDetail1.setProduct(productList.get(2));
        user.getCart().addCartDetailList(cartDetail1);


        User savedUser=userService.saveOrUpdate(user);
        assert savedUser.getId()!=null;
        assert savedUser.getVersion()!=null;
        assert savedUser.getCart().getId()!=null;
        assert savedUser.getCart()!=null;
        assert savedUser.getCart().getCartDetailList().size()==2;


        savedUser.getCart().removeCartDetailList(savedUser.getCart().getCartDetailList().get(0));



       userService.saveOrUpdate(savedUser);

        assert savedUser.getCart()!=null;
        assert savedUser.getCart().getCartDetailList().size()==1;




    }
}
