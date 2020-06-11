package com.example.market.controller;

import com.example.market.utils.param.OrderFormReq;
import com.example.market.dao.entity.OrderFormEntity;
import com.example.market.dao.entity.UserEntity;
import com.example.market.utils.FingCommityId;
import com.example.market.service.OrderFormService;
import com.example.market.utils.JsonXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 订单Controller
 */
@RestController
@RequestMapping("/deal")
public class OrderFormController {

    @Autowired
    OrderFormService orderFormService;

    /**
     * 创建订单
     * @param models 前端传入包含商品、用户和订单的数据
     */
    @PostMapping("/makedeal")
    public OrderFormEntity makeDeal(@RequestBody Map<String, String> models) throws Exception {
        //获取商品信息
        FingCommityId com = JsonXMLUtils.json2obj( models.get("com"), FingCommityId.class);

        //获取用户信息
        UserEntity userReq = JsonXMLUtils.json2obj(models.get("user"), UserEntity.class);

        //获取订单信息
        OrderFormReq deal = JsonXMLUtils.json2obj((models.get("deal")), OrderFormReq.class);

        //调用Service层创建订单操作，保存订单信息
        OrderFormEntity orderFormEntity = orderFormService.makeDealService(userReq.getId(),com.getComID(), deal);

        return orderFormEntity;
    }

}
