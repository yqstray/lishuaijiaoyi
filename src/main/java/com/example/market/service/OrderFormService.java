package com.example.market.service;

import com.example.market.utils.param.OrderFormReq;
import com.example.market.dao.entity.OrderFormEntity;

/**
 * 订单服务类
 */
public interface OrderFormService {

    //根据用户商品订单信息创建订单
    public OrderFormEntity makeDealService(Long userID, Long comID, OrderFormReq orderFormReq);
}
