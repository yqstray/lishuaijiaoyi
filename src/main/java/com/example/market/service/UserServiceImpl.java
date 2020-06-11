package com.example.market.service;

import com.example.market.utils.param.UserReq;
import com.example.market.dao.entity.OrderFormEntity;
import com.example.market.dao.entity.UserEntity;
import com.example.market.dao.repository.UserRepository;
import com.example.market.domain.OrderForm;
import com.example.market.domain.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * 判断用户名是否已被使用
     * @param userReq 用户信息
     * @return
     */
    @Override
    public boolean isUserAlreadyReg(UserReq userReq) {
        String username = userReq.getUsername();

        //通过dao层接口访问数据库，查询用户
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null){
            return false;
        }
        else
            return true;
    }

    /**
     * 创建用户
     * @param userReq 用户信息
     * @return
     */
    @Override
    public User createOne(UserReq userReq) {
        UserEntity userEntity = new UserEntity();
        //拷贝用户信息
        BeanUtils.copyProperties(userReq, userEntity);

        //保存用户信息
        userRepository.save(userEntity);
        User user = new User();

        //拷贝用户信息反馈给前端
        BeanUtils.copyProperties(userEntity, user);

        return user;
    }

    /**
     * 查询用户
     * @param username 用户名称
     * @param password 用户密码
     * @return
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        //通过dao层访问数据库，查询用户信息
        UserEntity userEntity = userRepository.findByUsernameAndPassword(username, password);
        User user = new User();

        //拷贝用户信息反馈给前端
        BeanUtils.copyProperties(userEntity,user);

        return user;
    }

    /**
     * 重新封装订单数据
     * @param dealEntities 订单信息
     * @return
     */
    @Override
    public Set<OrderForm> reMold(Set<OrderFormEntity> dealEntities) {
        Set<OrderForm> dealWithCommodities = new HashSet<>();

        //遍历订单信息
        for (OrderFormEntity orderFormEntity : dealEntities) {

            OrderForm orderForm = new OrderForm();
            orderForm.setC_name(orderFormEntity.getCommodityEntity().getComName());
            orderForm.setC_describe(orderFormEntity.getCommodityEntity().getComDescribe());
            orderForm.setC_prive(orderFormEntity.getCommodityEntity().getComPrice());
            orderForm.setD_location(orderFormEntity.getDealLocation());
            orderForm.setD_tele(orderFormEntity.getDealBuyerTelephone());
            orderForm.setD_time(orderFormEntity.getDealChangeTime());
            orderForm.setU_name(orderFormEntity.getCommodityEntity().getUser().getUsername());
            orderForm.setC_status(orderFormEntity.getCommodityEntity().getComStatus());
            orderForm.setC_id(orderFormEntity.getCommodityEntity().getComID());
            orderForm.setD_id(orderFormEntity.getDealID());

            //将订单信息封装至实体类
            dealWithCommodities.add(orderForm);
        }
        return dealWithCommodities;
    }

}
