package com.mahnoor.springmvc.services.jpaservices;

import com.mahnoor.springmvc.domain.Customer;
import com.mahnoor.springmvc.domain.User;
import com.mahnoor.springmvc.services.UserService;
import com.mahnoor.springmvc.services.sercurity.EncryptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
@Profile("jpadao")

public class UserServiceJPADaoImp extends  AbstractJPADaoService implements UserService {

    private EncryptorService encryptorService;

    @Autowired
    public void setEncryptorService(EncryptorService encryptorService) {
        this.encryptorService = encryptorService;
    }

    @Override
    public List<User> listAll() {
        EntityManager em= emf.createEntityManager();
        List<User> user= em.createQuery("From User", User.class).getResultList();
        em.close();
        return user;
    }

    @Override
    public User getById(Integer id) {
        EntityManager em= emf.createEntityManager();
        User user=  em.find(User.class,id);

        em.close();
        return user;
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        if(domainObject.getPassword()!=null){
            String encrytpedPwd=encryptorService.encryptString(domainObject.getPassword());
            domainObject.setEncryptedPassword(encrytpedPwd);
        }


        User saveduser=em.merge(domainObject);
        em.getTransaction().commit();
        em.close();
        return saveduser;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class,id));
        em.getTransaction().commit();
        em.close();
    }


}
