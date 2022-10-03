package com.mahnoor.springmvc.services.jpaservices;


import com.mahnoor.springmvc.domain.Customer;
import com.mahnoor.springmvc.domain.User;
import com.mahnoor.springmvc.services.CustomerService;
import com.mahnoor.springmvc.services.sercurity.EncryptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
@Profile("jpadao")
public class CustomerServiceJPADaoImp extends AbstractJPADaoService implements CustomerService {

    private EncryptorService encryptorService;

    @Autowired
    public void setEncryptorService(EncryptorService encryptorService) {
        this.encryptorService = encryptorService;
    }

    @Override
    public List<Customer> listAll() {
        EntityManager em= emf.createEntityManager();
        List<Customer> customers= em.createQuery("From Customer", Customer.class).getResultList();
        em.close();
        return customers;
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em= emf.createEntityManager();
        Customer customer=  em.find(Customer.class,id);

        em.close();
        return customer;
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        User user=domainObject.getUser();
        if(user!=null && user.getPassword()!=null){
            String encrytpedPwd=encryptorService.encryptString(user.getPassword());
            user.setEncryptedPassword(encrytpedPwd);
        }
        domainObject.setUser(user);
        Customer savedCustomer=em.merge(domainObject);
        em.getTransaction().commit();
        em.close();
        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class,id));
        em.getTransaction().commit();
        em.close();

    }
}
