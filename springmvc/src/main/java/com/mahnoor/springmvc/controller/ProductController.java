package com.mahnoor.springmvc.controller;

import com.mahnoor.springmvc.domain.Product;
import com.mahnoor.springmvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {

        this.productService = productService;
    }
    @RequestMapping({"/list", "/"})
    public String listProducts(Model model){
        model.addAttribute("products", this.productService.listAll());
        return "/product/list";
    }
    @RequestMapping("/show/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", this.productService.getById(id));
        return "/product/show";
    }
    @RequestMapping("/new")
    public String getForm(Model model){
        model.addAttribute("product",new Product());
        return "/product/productsForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdateProduct( Product product){
       Product savedOrUpdatedProduct= (Product) productService.saveOrUpdate(product);
       return "redirect:/product/show/"+(savedOrUpdatedProduct.getId());
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.delete(id);
        return "redirect:/product/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "/product/productsForm";
    }
}


