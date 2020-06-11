package com.example.market.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 管理员实体类类
 */
@Entity
@Data
@Table(name = "administrator")
public class AdministratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String emailAddress;
}
