package com.example.market.dao.repository;

import com.example.market.dao.entity.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface AdministratorRepository extends JpaRepository<AdministratorEntity,Long>, JpaSpecificationExecutor<AdministratorEntity>{

    //根据用户名和密码查询数据库
    public AdministratorEntity findByUsernameAndPassword(String username, String password);

}
