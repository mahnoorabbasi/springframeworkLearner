package com.mahnoor.springmvc.domain;

import com.mahnoor.springmvc.enums.OrderStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orders extends AbstractSuperClass{

    @OneToOne
    private Customer customer;

    @Embedded
    private Address shippingAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myOrder",orphanRemoval = true )
    private List<OrderDetail> orderDetails= new ArrayList<>();

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    private OrderStatus orderStatus;
    private Date dateShipped;



    public  void addToOrderDetails(OrderDetail orderDetail){
        orderDetail.setMyOrder(this);
        this.orderDetails.add(orderDetail);
    }

    public void removeFromOrderDetails(OrderDetail orderDetail){
        orderDetail.setMyOrder(null);
        this.orderDetails.remove(orderDetail);

    }




    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
