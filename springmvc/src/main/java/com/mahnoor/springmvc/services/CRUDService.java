package com.mahnoor.springmvc.services;

import com.mahnoor.springmvc.domain.DomainObject;
import com.mahnoor.springmvc.domain.Product;

import java.util.List;

public interface CRUDService<T> {
    public List<T> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);

}
