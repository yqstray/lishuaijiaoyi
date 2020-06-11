package com.example.market.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderForm {

    private String d_location;

    private LocalDateTime d_time;

    private String d_tele;

    private Double c_prive;

    private String c_name;

    private String c_describe;

    private String u_name;

    private String c_status;
    //商品id
    private Long c_id;
    //订单id
    private Long d_id;
}
