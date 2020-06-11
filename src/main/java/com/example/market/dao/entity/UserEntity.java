package com.example.market.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 *
 * @author roylurui
 *
 */

@Entity

@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String emailAddress;

    //商品set
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<CommodityEntity> commodityEntities = new HashSet<>();

    //订单set
    @OneToMany(mappedBy = "userEntity")
    @JsonBackReference
    private Set<OrderFormEntity> dealEntities = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<CommodityEntity> getCommodityEntities() {
        return commodityEntities;
    }

    public void setCommodityEntities(Set<CommodityEntity> commodityEntities) {
        this.commodityEntities = commodityEntities;
    }

    public Set<OrderFormEntity> getDealEntities() {
        return dealEntities;
    }

    public void setDealEntities(Set<OrderFormEntity> dealEntities) {
        this.dealEntities = dealEntities;
    }

}
