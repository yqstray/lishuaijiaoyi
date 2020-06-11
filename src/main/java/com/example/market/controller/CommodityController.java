package com.example.market.controller;

import com.example.market.utils.param.CommodityReq;
import com.example.market.utils.param.UserReq;
import com.example.market.dao.entity.CommodityEntity;
import com.example.market.dao.entity.OrderFormEntity;
import com.example.market.dao.repository.CommodityRepository;
import com.example.market.domain.Commodity;
import com.example.market.utils.FingCommityId;
import com.example.market.service.CommodityService;
import com.example.market.utils.JsonXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品controller
 */

@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @Autowired
    CommodityRepository commodityRepository;

    /**
     * 添加商品
     * @param models
     * @return
     * @throws Exception
     */
    @PostMapping("/addcommodity")
    public Commodity addCommodity(@RequestBody Map<String, String> models) throws Exception {
        //获取商品信息
        CommodityReq commodityReq = JsonXMLUtils.json2obj( models.get("com"), CommodityReq.class);

        //获取用户信息
        UserReq userReq = JsonXMLUtils.json2obj(models.get("user"), UserReq.class);

        //调用Service层添加商品
        Commodity commodity = commodityService.addCommodityFromOneUser(commodityReq, userReq);

        return commodity;
    }

    /**
     * 查找已发售商品
     * @return
     */
    @GetMapping("/findallcommodity")
    public List<CommodityEntity> findAll(){

        //调用Service层查找已发布状态的商品
        return commodityService.getStatus();
    }

    /**
     * 查找订单
     * @param fingCommityId
     * @return
     */
    @PostMapping("/finddeal")
    public OrderFormEntity findDeal(@RequestBody FingCommityId fingCommityId){

        //调用dao层访问数据库，根据商品id查找订单
        return commodityRepository.findByComID(fingCommityId.getComID()).getDeal();
    }

}
