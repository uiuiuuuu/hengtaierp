package com.hengtaierp.service;

import com.hengtaierp.doman.DataVo;
import com.hengtaierp.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author Administrator
* @description 针对表【system_user】的数据库操作Service
* @createDate 2023-01-31 14:30:43
*/
public interface SystemUserService extends IService<SystemUser> {

    DataVo login(String account, String password);


    DataVo addUser(HttpServletRequest httpServletRequest, SystemUser systemUser);
}
