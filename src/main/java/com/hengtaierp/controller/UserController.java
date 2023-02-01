package com.hengtaierp.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.api.R;
import com.hengtaierp.doman.DataVo;
import com.hengtaierp.entity.SystemUser;
import com.hengtaierp.listener.SystemUserListener;
import com.hengtaierp.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    @GetMapping("/menu")
    public DataVo menu(){


    }

    /**
     * 上传Excel 用户数锯
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), SystemUser.class, new SystemUserListener(systemUserService)).sheet().doRead();
        return "上传成功";
    }

}
