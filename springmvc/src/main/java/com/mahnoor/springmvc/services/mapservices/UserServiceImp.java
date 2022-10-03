package com.mahnoor.springmvc.services.mapservices;

import com.mahnoor.springmvc.domain.DomainObject;
import com.mahnoor.springmvc.domain.User;
import com.mahnoor.springmvc.services.UserService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class UserServiceImp extends AbstractMapService implements UserService {

    @Override
    public User saveOrUpdate(User domainObject) {
        return null;
    }

    public UserServiceImp() {
        super();
    }

    @Override
    public List listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer id) {
        return (User) super.getById(id);
    }

    @Override
    public User saveOrUpdate(DomainObject domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    protected void loadAllDominObject() {

    }
}
