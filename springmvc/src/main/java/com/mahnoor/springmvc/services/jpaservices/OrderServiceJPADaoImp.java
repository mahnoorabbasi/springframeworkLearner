package com.mahnoor.springmvc.services.jpaservices;

import com.mahnoor.springmvc.domain.Orders;
import com.mahnoor.springmvc.services.OrderService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
@Service
@Profile("jpadao")
public class OrderServiceJPADaoImp extends AbstractJPADaoService implements OrderService {




    @Override
    public List listAll() {
        EntityManager em=emf.createEntityManager();
        List<Orders> orders=em.createQuery("from Order", Orders.class).getResultList();
        em.close();
        return orders;
    }

    @Override
    public Orders getById(Integer id) {
        EntityManager em= emf.createEntityManager();
        Orders order=  em.find(Orders.class,id);

        em.close();
        return order;
    }


    @Override
    public Orders saveOrUpdate(Orders domainObject) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Orders savedOrder=em.merge(domainObject);
        em.getTransaction().commit();
        em.close();

        return savedOrder;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Orders.class,id));
        em.getTransaction().commit();
        em.close();


    }
}
