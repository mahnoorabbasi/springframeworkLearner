package com.mahnoor.springmvc.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Cart extends AbstractSuperClass {


    @OneToOne
    private User user;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    private Integer quantity;


    @OneToMany(cascade=CascadeType.ALL, mappedBy="cart",  orphanRemoval=true)
    private List<CartDetail> cartDetailList=new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public List<CartDetail> getCartDetailList() {
        return cartDetailList;
    }

    public void setCartDetailList(List<CartDetail> cartDetailList) {
        this.cartDetailList = cartDetailList;
    }

    public void addCartDetailList(CartDetail cartDetail) {
        this.cartDetailList.add(cartDetail);
        cartDetail.setCart(this);
    }

    public void removeCartDetailList(CartDetail cartDetail) {
        cartDetail.setCart(null);
        this.cartDetailList.remove(cartDetail);
    }
}
