package com.example.demo090;

import com.example.market.dao.entity.OrderFormEntity;
import com.example.market.dao.entity.UserEntity;
import com.example.market.dao.repository.CommodityRepository;
import com.example.market.dao.repository.OrderFormRepository;
import com.example.market.dao.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class marketApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    OrderFormRepository orderFormRepository;


    @Test
    void contextLoads() {
//        CommodityEntity commodityEntity = new CommodityEntity();
//        commodityEntity.setComName("datao");
//
//
//        UserEntity admin = userRepository.findByUsername("admin");
//
//        commodityEntity.setUser(admin);
//
//        commodityRepository.save(commodityEntity);
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("王");
//
//        //userEntity.getCommodityEntities().add(commodityEntity);
//        commodityEntity.setUser(userEntity);
//
//        userRepository.save(userEntity);
//        commodityRepository.save(commodityEntity);
//        commodityRepository.findByComID()

        /*
        交易测试
        UserEntity user = userRepository.findByUsername("haha");
        CommodityEntity commodity = commodityRepository.findByComID((long) 14);

        DealEntity deal = new DealEntity();
        deal.setDealLocation("教学楼");
        DealEntity dealEntity = dealRepository.save(deal);


        dealEntity.setCommodityEntity(commodity);
        dealEntity.setUserEntity(user);
        commodity.setComStatus("traded");

        dealRepository.save(dealEntity);
        commodityRepository.save(commodity);
        */
        UserEntity haha = userRepository.findByUsername("admin");

        Set<OrderFormEntity> dealEntities = haha.getDealEntities();
        for (OrderFormEntity orderFormEntity : dealEntities) {
            System.out.println(orderFormEntity);
        }
//        System.out.println(haha.getCommodityEntities().toString());

    }

}
