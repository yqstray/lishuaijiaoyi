package com.example.market.service;

import com.example.market.utils.param.OrderFormReq;
import com.example.market.dao.entity.CommodityEntity;
import com.example.market.dao.entity.OrderFormEntity;
import com.example.market.dao.repository.CommodityRepository;
import com.example.market.dao.repository.OrderFormRepository;
import com.example.market.dao.repository.UserRepository;
import com.example.market.service.OrderFormService;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFormServiceImpl implements OrderFormService {

    @Autowired
    OrderFormRepository orderFormRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommodityRepository commodityRepository;

    /**
     * 创建订单
     * @param userID 用户id
     * @param comID 商品id
     * @param orderFormReq 订单信息
     * @return
     */
    @Override
    public OrderFormEntity makeDealService(Long userID, Long comID, OrderFormReq orderFormReq) {
        OrderFormEntity target = new OrderFormEntity();
        //拷贝订单数据
        BeanUtils.copyProperties(orderFormReq,target);

        //保存订单数据
        target = orderFormRepository.save(target);

        //通过dao层访问数据库，把用户信息存入订单
        target.setUserEntity(userRepository.findById(userID).get());

        //通过dao层访问数据库，把商品信息存入订单
        target.setCommodityEntity(commodityRepository.findByComID(comID));

        //通过dao层访问数据库，查询商品
        CommodityEntity commodity = commodityRepository.findByComID(comID);

        //修改商品状态为已售出
        commodity.setComStatus("traded");

        //将订单信息存入商品
        commodity.setDeal(target);

        //保存订单信息
        OrderFormEntity OrderForm = orderFormRepository.save(target);

        return OrderForm;
    }
}
