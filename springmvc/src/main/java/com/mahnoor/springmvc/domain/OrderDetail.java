package com.mahnoor.springmvc.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class OrderDetail extends AbstractSuperClass{


    @ManyToOne
    private Orders myOrder;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @OneToOne
    private Product product;
    private Integer quantity;

    public Orders getMyOrder() {
        return myOrder;
    }

    public void setMyOrder(Orders myOrder) {
        this.myOrder = myOrder;
    }
}
