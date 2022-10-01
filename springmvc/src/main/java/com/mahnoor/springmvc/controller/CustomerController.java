package com.mahnoor.springmvc.controller;

import com.mahnoor.springmvc.domain.Customer;
import com.mahnoor.springmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService=customerService;
    }

//    @RequestMapping("/customers")
    @RequestMapping({"/list","/"})
    public String listAllCustomers(Model model){
        model.addAttribute("customers", this.customerService.listAll());
        return "/customer/list";

    }

    @RequestMapping("/show/{id}")
    public String getCustomerById(@PathVariable Integer id, Model model){
        Customer customer= (Customer) customerService.getById(id);
        model.addAttribute("customer", customer);
        return "/customer/show"; //folder path
    }

@RequestMapping("/edit/{id}")
public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customersForm";
}

    //an empty form to fill
    @RequestMapping("/new")
    public String getForm(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/customersForm";
    }

    //post method/ of fulfilling that form
//    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer){
        Customer newCustomer=customerService.saveOrUpdate(customer);
        return "redirect:/customer/show/"+(newCustomer.getId());
    }
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }




}


