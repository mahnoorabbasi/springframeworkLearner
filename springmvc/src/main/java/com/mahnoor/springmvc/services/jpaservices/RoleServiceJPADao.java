package com.mahnoor.springmvc.services.jpaservices;


import com.mahnoor.springmvc.domain.Orders;
import com.mahnoor.springmvc.domain.security.Roles;
import com.mahnoor.springmvc.services.RoleService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class RoleServiceJPADao extends AbstractJPADaoService implements RoleService {
    @Override
    public List<Roles> listAll() {
        EntityManager em=emf.createEntityManager();
        List<Roles> roles=em.createQuery("from Roles", Roles.class).getResultList();
        em.close();
        return roles;
    }

    @Override
    public Roles getById(Integer id) {
        EntityManager em= emf.createEntityManager();
        Roles role=  em.find(Roles.class,id);

        em.close();
        return role;
    }

    @Override
    public Roles saveOrUpdate(Roles domainObject) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Roles savedRole=em.merge(domainObject);
        em.getTransaction().commit();
        em.close();

        return savedRole;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Roles.class,id));
        em.getTransaction().commit();
        em.close();
    }
}
