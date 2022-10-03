package com.mahnoor.springmvc.services.jpaservices;


import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


public class AbstractJPADaoService {

    protected EntityManagerFactory emf;
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

}
