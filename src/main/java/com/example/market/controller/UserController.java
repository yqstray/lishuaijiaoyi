package com.example.market.controller;

import com.example.market.utils.param.UserReq;
import com.example.market.dao.entity.CommodityEntity;
import com.example.market.dao.entity.UserEntity;
import com.example.market.dao.repository.CommodityRepository;
import com.example.market.dao.repository.OrderFormRepository;
import com.example.market.dao.repository.UserRepository;
import com.example.market.domain.OrderForm;
import com.example.market.domain.User;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户controller
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private static final int USERALREADYEXIST = -1;

    @Autowired
    UserService userService;

    @Autowired
    OrderFormRepository orderFormRepository;

    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 用户注册
     * @param userReq 用户个人信息
     * @return
     */
    @PostMapping("/register")
    public User registerUser(@RequestBody UserReq userReq){
        //调用Service层方法，验证用户是否存在
        if (userService.isUserAlreadyReg(userReq)){
            User error_user = new User();
            error_user.setId(USERALREADYEXIST);
            error_user.setPassword("alreadyused");
            error_user.setUsername("alreadyused");
            return error_user;
        }

        //调用Service层方法，根据用户信息新建用户
        else {
            User user = userService.createOne(userReq);
            return user;
        }

    }

    /**
     * 用户登录
     * @param userReq 用户个人信息
     * @return
     */
    @PostMapping("/login")
    public User findUserByData(@RequestBody UserReq userReq){
        User user = null;

        //调用Service层方法新建用户对象
        user = userService.findUserByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
        return user;
    }

    /**
     * 查询用户发布的商品
     * @param user 用户信息
     * @return
     */
    @PostMapping("/getcombyuser")
    public Set<CommodityEntity> getCommodityByUser(@RequestBody User user){
        Set<CommodityEntity> tradedCommodity = new HashSet<>();

        //调用dao层数据库查询入口，根据用户ID查询商品
        Set<CommodityEntity> allCommodities = userRepository.findById(user.getId()).get().getCommodityEntities();

        //遍历所有商品，搜索已审核与已发售的商品
        for (CommodityEntity commodity : allCommodities) {
            if ("released".equals(commodity.getComStatus()) || "traded".equals(commodity.getComStatus())){
                tradedCommodity.add(commodity);
            }
        }

        return tradedCommodity;
    }

    /**
     * 查询用户创建的订单
     * @param user 用户信息
     * @return
     */
    @PostMapping("/getdealbyuser")
    public Set<OrderForm> getDealByUser(@RequestBody User user){
        //调用Service接口的重新封装方法，对使用dao层查询到的用户的信息，分装到订单实体中
        Set<OrderForm> iters = userService.reMold(userRepository.findById(user.getId()).get().getDealEntities());
        Set<OrderForm> finalSet = new HashSet<>();

        //遍历封装好的订单，查询状态为已售出的订单的信息
        for (OrderForm orderForm : iters) {
            if ("traded".equals(orderForm.getC_status())){
                finalSet.add(orderForm);
            }
        }
        return finalSet;
    }

}
