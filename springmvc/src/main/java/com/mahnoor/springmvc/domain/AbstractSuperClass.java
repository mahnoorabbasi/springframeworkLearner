package com.mahnoor.springmvc.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@MappedSuperclass
public class AbstractSuperClass implements DomainObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    @Version
    protected Integer version;
    private Date dateCreated;
    private Date dateUpdated;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps(){
        dateUpdated=new Date();
        if(dateCreated==null){
            dateUpdated=new Date();
        }
    }

}
