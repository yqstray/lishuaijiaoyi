package com.example.market.service;

import com.example.market.utils.param.UserReq;
import com.example.market.dao.entity.OrderFormEntity;
import com.example.market.domain.OrderForm;
import com.example.market.domain.User;

import java.util.Set;

public interface UserService {
    //判断用户是否已经存在
    public boolean isUserAlreadyReg(UserReq userReq);

    //创建用户
    public User createOne(UserReq userReq);

    //查找用户
    public User findUserByUsernameAndPassword(String username, String password);

    //重新封装订单
    public Set<OrderForm> reMold(Set<OrderFormEntity> dealEntities);
}
