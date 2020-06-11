package com.example.market.dao.repository;

import com.example.market.dao.entity.CommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommodityRepository extends JpaRepository<CommodityEntity,Long> , JpaSpecificationExecutor<CommodityEntity> {
    //根据商品ID查询数据库
    public CommodityEntity findByComID(Long id);

    //根据商品状态查询数据库
    public List<CommodityEntity> findByComStatus(String status);


}
