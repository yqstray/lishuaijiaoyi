package com.example.market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {

    private Long comID;

    private Double comPrice;

    private String comName;

    private String comDescribe;

    private LocalDateTime comReleaseTime;

    private String comStatus;
}
