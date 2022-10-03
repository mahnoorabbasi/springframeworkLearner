package com.mahnoor.springmvc.domain;


import javax.persistence.*;
@Entity
public class User extends DomainObject{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;
    private String username;
    @Transient
    private String password;

    private String encryptedPassword;
    private boolean isEnabled=true;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    Cart cart;

    @OneToOne( cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private Customer customer;
    public User() {
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(Integer id, Integer version, String username, String password, String encryptedPassword, boolean isEnabled) {
        this.id = id;
        this.version = version;
        this.username = username;
        this.password = password;
        this.encryptedPassword = encryptedPassword;
        this.isEnabled = isEnabled;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.setUser(this);
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
