package com.hengtaierp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hengtaierp.doman.DataVo;
import com.hengtaierp.entity.SystemUser;
import com.hengtaierp.service.SystemUserService;
import com.hengtaierp.mapper.SystemUserMapper;
import com.hengtaierp.utils.JwtUtils;
import com.hengtaierp.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Administrator
 * @description 针对表【system_user】的数据库操作Service实现
 * @createDate 2023-01-31 14:30:43
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {


    @Autowired
    SystemUserMapper systemUserMapper;

    @Override
    public DataVo login(String account, String password) {
        String md5Password = Md5Utils.getMd5(password);


        DataVo dataVo = new DataVo<>();
        QueryWrapper login = new QueryWrapper<>();
        login.eq("account", account);

        SystemUser user = systemUserMapper.selectOne(login);

        if (Objects.isNull(user)) {
            dataVo.setCode(0);
            dataVo.setMessage("用户或密码错误！");
            dataVo.setData(null);
            return dataVo;
        } else if (!Md5Utils.getMd5(user.getPassword()).equals(md5Password)) {
            dataVo.setCode(0);
            dataVo.setMessage("用户或密码错误！");
            dataVo.setData(null);
            return dataVo;
        }

        Map<String, Object> token = new HashMap<>();

        dataVo.setCode(1);
        dataVo.setMessage("登录成功");
        token.put("Authorization", JwtUtils.getToken(user));


        dataVo.setData(token);


        return dataVo;
    }
}




