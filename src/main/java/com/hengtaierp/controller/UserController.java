package com.hengtaierp.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.api.R;
import com.hengtaierp.doman.DataVo;
import com.hengtaierp.doman.MenuVo;
import com.hengtaierp.entity.SystemUser;
import com.hengtaierp.listener.SystemUserListener;
import com.hengtaierp.service.SystemMenuService;
import com.hengtaierp.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {



    @Autowired
    SystemUserService systemUserService;

    @Autowired
    SystemMenuService systemMenuService;

    /**
     *  登录
     * @param account
     * @param password
     * @return
     */
    @PostMapping("/login")
    public DataVo login(String account,String password){
        return systemUserService.login(account,password);
    }

    /**
     * 获取用户权限菜单
     *
     * @param httpServletRequest
     * @return
     */
    @GetMapping("/menu")
    public MenuVo menu(HttpServletRequest httpServletRequest){
       return systemMenuService.menu(httpServletRequest);
    }


    @PostMapping("/add")
    public DataVo addUser(HttpServletRequest httpServletRequest,@RequestBody SystemUser systemUser){

        return systemUserService.addUser(httpServletRequest,systemUser);
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
