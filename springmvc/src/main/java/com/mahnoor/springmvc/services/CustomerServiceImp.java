package com.mahnoor.springmvc.services;

import com.mahnoor.springmvc.domain.Customer;
import com.mahnoor.springmvc.domain.DomainObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("map")
public class CustomerServiceImp extends AbstractMapService implements CustomerService{



    @Override
    protected void loadAllDominObject() {
        domainMap= new HashMap<>();
        Customer customer= new Customer(1,"Mahnoor1","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                 "Punjab", "5400");
        domainMap.put(customer.getId(),customer);
        customer= new Customer(2,"Mahnoor2","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        domainMap.put(customer.getId(),customer);
        customer= new Customer(3,"Mahnoor3","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        domainMap.put(customer.getId(),customer);
        customer= new Customer(4,"Mahnoor4","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        domainMap.put(customer.getId(),customer);
        customer= new Customer(5,"Mahnoor5","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        domainMap.put(customer.getId(),customer);
        customer= new Customer(6,"Mahnoor6","Ababsi",
                "mabbasi@xavor.com", "9234", "AD1", "AD2", "Lahore",
                "Punjab", "5400");
        domainMap.put(customer.getId(),customer);

    }




    @Override
    public List listAll() {
        return super.listAll();

    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate((Customer) domainObject);
    }



    @Override
    public void delete(Integer id) {
        super.delete(id);

    }
}
