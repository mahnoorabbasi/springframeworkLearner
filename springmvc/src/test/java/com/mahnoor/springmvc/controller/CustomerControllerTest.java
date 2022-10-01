package com.mahnoor.springmvc.controller;

import com.mahnoor.springmvc.controller.CustomerController;
import com.mahnoor.springmvc.domain.Customer;
import com.mahnoor.springmvc.domain.DomainObject;
import com.mahnoor.springmvc.domain.Product;
import com.mahnoor.springmvc.services.CustomerService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(customerController).build();
    }
    @Test
    public void testListAll() throws Exception {
        List<Customer> myList = new ArrayList<>();
        myList.add(new Customer());
        myList.add(new Customer());

        when(customerService.listAll()).thenReturn(myList);
        mockMvc.perform(get("/customer/"))
                .andExpect((status().isOk()))
                .andExpect(view().name("/customer/list"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }
    @Test
    public void testShow() throws Exception {
        Integer id=1;
        when(customerService.getById(id)).thenReturn(new Customer());
        mockMvc.perform(get("/customer/show/1"))
                .andExpect((status().isOk()))
                .andExpect(view().name("/customer/show"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testEdit() throws Exception {
        Integer id=1;
        when(customerService.getById(id)).thenReturn(new Customer());
        mockMvc.perform(get("/customer/edit/1"))
                .andExpect((status().isOk()))
                .andExpect(view().name("customer/customersForm"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }
    @Test
    public void testNewCustomer() throws Exception {
       verifyZeroInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
                .andExpect((status().isOk()))
                .andExpect(view().name("/customer/customersForm"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void saveOrUpdateCustomer() throws Exception {
        Integer id = 1;
        Customer returnCustomer = new Customer();
        String firstName = "Micheal";
        String lastName = "Weston";
        String addressLine1 = "1 Main St";
        String addressLine2 = "Apt 301";
        String city = "Miami";
        String state = "Florida";
        String zipCode = "33101";
        String email = "micheal@burnnotice.com";
        String phoneNumber = "305.333.0101";

        returnCustomer.setId(id);
        returnCustomer.setFirstName(firstName);
        returnCustomer.setLastName(lastName);
        returnCustomer.setAddressLineOne(addressLine1);
        returnCustomer.setAddressLineTwo(addressLine2);
        returnCustomer.setCity(city);
        returnCustomer.setState(state);
        returnCustomer.setZipCode(zipCode);
        returnCustomer.setEmail(email);
        returnCustomer.setPhoneNumber(phoneNumber);

        when(customerService.saveOrUpdate(org.mockito.Matchers.<Customer>any())).thenReturn(returnCustomer);
        mockMvc.perform(post("/customer")
                        .param("id", "1")
                        .param("firstName", firstName)
                        .param("lastName", lastName)
                        .param("addressLineOne", addressLine1)
                        .param("addressLineTwo", addressLine2)
                        .param("city", city)
                        .param("state", state)
                        .param("zipCode", zipCode)
                        .param("email", email)
                        .param("phoneNumber", phoneNumber))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/show/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
                .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
                .andExpect(model().attribute("customer", hasProperty("addressLineOne", is(addressLine1))))
                .andExpect(model().attribute("customer", hasProperty("addressLineTwo", is(addressLine2))))
                .andExpect(model().attribute("customer", hasProperty("city", is(city))))
                .andExpect(model().attribute("customer", hasProperty("state", is(state))))
                .andExpect(model().attribute("customer", hasProperty("zipCode", is(zipCode))))
                .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))));

        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(customerCaptor.capture());

        Customer boundCustomer = customerCaptor.getValue();

        assertEquals(id, boundCustomer.getId());
        assertEquals(firstName, boundCustomer.getFirstName());
        assertEquals(lastName, boundCustomer.getLastName());
        assertEquals(addressLine1, boundCustomer.getAddressLineOne());
        assertEquals(addressLine2, boundCustomer.getAddressLineTwo());
        assertEquals(city, boundCustomer.getCity());
        assertEquals(state, boundCustomer.getState());
        assertEquals(zipCode, boundCustomer.getZipCode());
        assertEquals(email, boundCustomer.getEmail());
        assertEquals(phoneNumber, boundCustomer.getPhoneNumber());
    }



}
