package com.example.market.service;

import com.example.market.utils.param.CommodityReq;
import com.example.market.utils.param.UserReq;
import com.example.market.dao.entity.CommodityEntity;
import com.example.market.dao.entity.UserEntity;
import com.example.market.dao.repository.CommodityRepository;
import com.example.market.dao.repository.UserRepository;
import com.example.market.domain.Commodity;
import com.example.market.service.CommodityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityRepository commodityRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 查找已审核的商品
     * @return
     */
    @Override
    public List<CommodityEntity> getStatus() {
        //调用dao层访问数据库，查找已审核的商品
        return commodityRepository.findByComStatus("released");
    }

    /**
     * 添加商品
     * @param commodityReq 商品信息
     * @param userReq 用户信息
     * @return
     */
    @Override
    public Commodity addCommodityFromOneUser(CommodityReq commodityReq, UserReq userReq) {
        CommodityEntity commodityEntity = new CommodityEntity();
        UserEntity userEntity = new UserEntity();

        //将前端数据拷贝至实体类
        BeanUtils.copyProperties(commodityReq,commodityEntity);
        BeanUtils.copyProperties(userReq,userEntity);

        //设置商品状态为未审核
        commodityEntity.setComStatus("unchecked");

        //通过dao层访问数据库，查询用户信息
        UserEntity out = userRepository.findByUsername(userReq.getUsername());

        //关联用户信息和商品信息
        commodityEntity.setUser(out);

        //保存商品
        commodityRepository.save(commodityEntity);

        //拷贝商品信息进行输出
        Commodity commodity = new Commodity();
        BeanUtils.copyProperties(commodityReq,commodity);

        return commodity;
    }
}
