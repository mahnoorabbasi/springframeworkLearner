package com.mahnoor.springmvc.controller;

import com.mahnoor.springmvc.controller.*;
import com.mahnoor.springmvc.domain.*;
import com.mahnoor.springmvc.services.*;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;

import java.awt.color.*;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(productController).build();

    }

    @Test
    public void testListAll() throws Exception {
        List<Product> myList = new ArrayList<>();
        myList.add(new Product());
        myList.add(new Product());

        when(productService.listAll()).thenReturn((List) myList);
        mockMvc.perform(get("/product/list"))
                .andExpect((status().isOk()))
                .andExpect(view().name("/product/list"))
                .andExpect(model().attribute("product", hasSize(2)));
    }
        @Test
        public void testShow() throws Exception {
            Integer id=1;

            when(productService.getById(id)).thenReturn(new Product());
            mockMvc.perform(get("/product/show/1"))
                    .andExpect((status().isOk()))
                    .andExpect(view().name("/product/show"))
                    .andExpect(model().attribute("product", instanceOf(Product.class)));
        }





}
