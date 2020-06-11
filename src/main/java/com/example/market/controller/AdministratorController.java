package com.example.market.controller;

import com.example.market.utils.param.UserReq;
import com.example.market.dao.entity.AdministratorEntity;
import com.example.market.dao.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员Controller
 */

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    AdministratorRepository administratorRepository;

    /**
     * 管理员登录，通过查找管理员的用户名和密码实现管理员登录
     * @param userReq 用户个人信息
     * @return
     */

    @PostMapping("/login")
    public AdministratorEntity findAdminByData(@RequestBody UserReq userReq){
        AdministratorEntity admin = null;

        //通过管理员账号密码查找个人信息
        admin = administratorRepository.findByUsernameAndPassword(userReq.getUsername(), userReq.getPassword());
        return admin;
    }

}
