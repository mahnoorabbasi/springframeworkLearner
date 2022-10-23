package com.mahnoor.springmvc.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AbstractSuperClass {

    private String firstName, lastName, email, phoneNumber;


    @OneToMany(cascade=CascadeType.ALL, mappedBy="customer",  orphanRemoval=true)
    private List<Orders> order= new ArrayList<>();

    @Embedded
    @AttributeOverride(name="addressLine1",column=@Column(name="addressLine1"))
    @AttributeOverride(name="addressLine2",column=@Column(name="addressLine2"))
    @AttributeOverride(name="city",column=@Column(name="city"))
    @AttributeOverride(name="state",column=@Column(name="state"))
    @AttributeOverride(name="zipCode",column=@Column(name="zipCode"))
    private Address billingAddress;

    @Embedded
    @AttributeOverride(name="addressLine1",column=@Column(name="shippingAddressaddressLine1"))
    @AttributeOverride(name="addressLine2",column=@Column(name="shippingAddressaddressLine2"))
    @AttributeOverride(name="city",column=@Column(name="shippingAddresscity"))
    @AttributeOverride(name="state",column=@Column(name="shippingAddressstate"))
    @AttributeOverride(name="zipCode",column=@Column(name="shippingAddresszipCode"))
    private Address shippingAddress;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    private User user;

    public List<Orders> getOrder() {
        return order;
    }

    public void setOrder(List<Orders>  order) {
        this.order = order;
    }
    public void addOrder(Orders order){
        this.order.add(order);
    }

    public void removeOrder(Orders order){
        this.order.remove(order);
    }

    public Customer(Integer version, String firstName, String lastName, String email, String phoneNumber, Address billingAddress, Address shippingAddress, User user) {
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.user = user;
    }

    public Customer(String firstName, String lastName, String email, String phoneNumber, Address billingAddress, Address shippingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

    public Customer(Integer id, String firstName, String lastName, String email, String phoneNumber, Address billingAddress, Address shippingAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

    public Customer() {

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
