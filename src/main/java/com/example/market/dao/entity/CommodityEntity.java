package com.example.market.dao.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;



/**
 * 商品实体类
 */
@Entity

@Table(name = "Commodity")
public class CommodityEntity {

    //商品id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commodity_id")
    private Long comID;

    //商品价格
    @Column(name = "commodity_price")
    private Double comPrice;

    //商品名字
    @Column(name = "commodity_name")
    private String comName;

    //商品描述
    @Column(name = "commodity_remark")
    private String comDescribe;

    //发布时间
    @Column(name = "commodity_time")
    private LocalDateTime comReleaseTime;

    //商品状态
    //unchecked 未审核
    //release 已发布
    //traded 已售出
    @Column(name = "commodity_state")
    private String comStatus;

    //和用户创建多对一关系
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name = "seller_id",referencedColumnName = "id")
    @JsonManagedReference
    private UserEntity user;

    //和交易表建立一对一联系
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    @JsonBackReference
    private OrderFormEntity deal;


    public Long getComID() {
        return comID;
    }

    public void setComID(Long comID) {
        this.comID = comID;
    }

    public Double getComPrice() {
        return comPrice;
    }

    public void setComPrice(Double comPrice) {
        this.comPrice = comPrice;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComDescribe() {
        return comDescribe;
    }

    public void setComDescribe(String comDescribe) {
        this.comDescribe = comDescribe;
    }

    public LocalDateTime getComReleaseTime() {
        return comReleaseTime;
    }

    public void setComReleaseTime(LocalDateTime comReleaseTime) {
        this.comReleaseTime = comReleaseTime;
    }

    public String getComStatus() {
        return comStatus;
    }

    public void setComStatus(String comStatus) {
        this.comStatus = comStatus;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public OrderFormEntity getDeal() {
        return deal;
    }

    public void setDeal(OrderFormEntity deal) {
        this.deal = deal;
    }

}
