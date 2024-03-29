package com.mahnoor.springmvc.services.mapservices;

import com.mahnoor.springmvc.domain.DomainObject;
import org.springframework.stereotype.Service;

import java.util.*;

public abstract class AbstractMapService {
    protected Map<Integer, DomainObject> domainMap;

    public AbstractMapService() {
        this.domainMap = new HashMap<>();
        loadAllDominObject();
    }

    protected abstract void loadAllDominObject() ;

    public List<DomainObject> listAll(){
        return new ArrayList<>(domainMap.values());
    }
    public DomainObject getById(Integer id){
        return domainMap.get(id);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject){
        if(domainObject!=null){
            if(domainObject.getId()==null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(),domainObject);

            return domainObject;

        }else
            throw new RuntimeException("Object cannot be null");
    }


    private Integer getNextKey() {
        return Collections.max(domainMap.keySet())+1;
    }

    public void delete(Integer id){
        domainMap.remove(id);
    }
}
