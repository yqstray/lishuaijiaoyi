package com.example.market.service;

import com.example.market.utils.param.CommodityReq;
import com.example.market.utils.param.UserReq;
import com.example.market.dao.entity.CommodityEntity;
import com.example.market.domain.Commodity;

import java.util.List;

public interface CommodityService {

    //获取商品状态为已审核的商品信息
    public  List<CommodityEntity> getStatus();

    //添加商品
    public Commodity addCommodityFromOneUser(CommodityReq commodityReq, UserReq userReq);

}
