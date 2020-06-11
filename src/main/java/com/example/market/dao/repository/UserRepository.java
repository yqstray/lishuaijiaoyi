package com.example.market.dao.repository;

import com.example.market.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    //根据用户id查询数据库
    public Optional<UserEntity> findById(Long id);

    //根据用户名查询数据库
    public UserEntity findByUsername(String username);

    //根据用户名和密码查询数据库
    public UserEntity findByUsernameAndPassword(String username,String password);
}
