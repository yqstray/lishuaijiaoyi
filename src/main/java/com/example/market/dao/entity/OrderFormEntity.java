package com.example.market.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 订单实体类
 */
@Entity

@Table(name = "orderform")
public class OrderFormEntity {

    //交易id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderform_id")
    private Long dealID;

    //交易地点
    @Column(name = "orderform_location")
    private String dealLocation;

    //交易时间
    @Column(name = "orderform_time")
    private LocalDateTime dealChangeTime;

    //交易人电话号码
    @Column(name = "orderform_emailaddress")
    private String dealBuyerTelephone ;

    //和商品表建立一对一联系
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commodity_id")
    @JsonManagedReference
    private CommodityEntity commodityEntity;

    //和用户表建立多对一联系
    @JsonManagedReference
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    private UserEntity userEntity;

    public Long getDealID() {
        return dealID;
    }

    public void setDealID(Long dealID) {
        this.dealID = dealID;
    }

    public String getDealLocation() {
        return dealLocation;
    }

    public void setDealLocation(String dealLocation) {
        this.dealLocation = dealLocation;
    }

    public LocalDateTime getDealChangeTime() {
        return dealChangeTime;
    }

    public void setDealChangeTime(LocalDateTime dealChangeTime) {
        this.dealChangeTime = dealChangeTime;
    }

    public CommodityEntity getCommodityEntity() {
        return commodityEntity;
    }

    public void setCommodityEntity(CommodityEntity commodityEntity) {
        this.commodityEntity = commodityEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getDealBuyerTelephone() {
        return dealBuyerTelephone;
    }

    public void setDealBuyerTelephone(String dealBuyerTelephone) {
        this.dealBuyerTelephone = dealBuyerTelephone;
    }


}
