package com.mahnoor.springmvc.domain.security;

import com.mahnoor.springmvc.domain.AbstractSuperClass;
import com.mahnoor.springmvc.domain.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Roles extends AbstractSuperClass {
    private String role;



    @ManyToMany
    @JoinTable
    //default values will be below:
    //@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "role_id"),
    //       inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users=new ArrayList<>();


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public void addUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }

        if(!user.getRoles().contains(this)){
            user.getRoles().add(this);
            ///ensure that usr's role list must also have this role assigned to it
        }
    }


    public void removeUser(User user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }
}
