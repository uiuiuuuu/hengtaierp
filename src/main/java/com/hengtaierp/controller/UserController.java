package com.hengtaierp.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.hengtaierp.doman.DataVo;
import com.hengtaierp.entity.SystemUser;
import com.hengtaierp.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {



    @Autowired
    SystemUserService systemUserService;

    /**
     * 使用用户对象登录
     * @param systemUser  账号 account   密码  password
     * @return
     */
    @PostMapping("/login")
    public DataVo login(@RequestBody SystemUser systemUser){
        return systemUserService.login(systemUser);
    }
    @GetMapping("/test")
    public String test(){
        return "Hello Word";

    }
}
