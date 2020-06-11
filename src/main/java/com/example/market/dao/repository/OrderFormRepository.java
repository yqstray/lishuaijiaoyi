package com.example.market.dao.repository;

import com.example.market.dao.entity.OrderFormEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderFormRepository extends JpaRepository<OrderFormEntity,Long>, JpaSpecificationExecutor<OrderFormEntity> {
}
