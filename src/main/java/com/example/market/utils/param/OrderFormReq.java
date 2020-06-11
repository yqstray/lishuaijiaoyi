package com.example.market.utils.param;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderFormReq {
    //交易地点
    private String dealLocation;

    //交易时间
    private LocalDateTime dealChangeTime;

    //交易人电话号码
    private String dealBuyerTelephone ;

}
