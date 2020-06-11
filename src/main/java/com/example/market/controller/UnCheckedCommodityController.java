package com.example.market.controller;

import com.example.market.dao.entity.CommodityEntity;
import com.example.market.dao.repository.CommodityRepository;
import com.example.market.utils.FingCommityId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 管理员审核商品Controller
 */
@RestController
@RequestMapping("/unhandled")
public class UnCheckedCommodityController {

    @Autowired
    CommodityRepository commodityRepository;

    /**
     * 查找未审核商品
     * @return
     */
    @GetMapping("/findall")
    public List<CommodityEntity> findAll(){

        //调用dao层数据库查找未审核商品
        return commodityRepository.findByComStatus("unchecked");
    }

    /**
     * 修改商品状态
     * @paramFingCommitId 商品id
     * @return
     */
    @PostMapping("/changestatus")
    public CommodityEntity changeStatus(@RequestBody FingCommityId fingCommityId){
        //调用dao层数据库访问，查找商品
        CommodityEntity commodityEntity = commodityRepository.findByComID(fingCommityId.getComID());

        //修改商品实体类状态
        commodityEntity.setComStatus("released");

        //保存修改结果
        commodityRepository.save(commodityEntity);

        return commodityEntity;
    }

}
