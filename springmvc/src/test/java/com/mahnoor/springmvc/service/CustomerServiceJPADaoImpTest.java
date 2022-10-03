package com.mahnoor.springmvc.service;

import com.mahnoor.springmvc.domain.Customer;
import com.mahnoor.springmvc.domain.Product;
import com.mahnoor.springmvc.domain.User;
import com.mahnoor.springmvc.services.CustomerService;
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
public class CustomerServiceJPADaoImpTest {
    private CustomerService customerService;
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Test
    public void listAllTest() {
        List<Customer> customerList=customerService.listAll();
        assert customerList.size() == 5;
    }

    @Test
    public void saveOrUpdateTest() {
        Customer customer = new Customer();
        User user=new User();
        user.setUsername("ImNewUser");
        user.setPassword("ImItsPassword");
        customer.setUser(user);

        Customer savedCustomer=customerService.saveOrUpdate(customer);

        assert savedCustomer.getUser().getEncryptedPassword()!=null;





    }

}
