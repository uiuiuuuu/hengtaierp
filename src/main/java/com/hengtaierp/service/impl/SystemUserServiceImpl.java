package com.hengtaierp.service.impl;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hengtaierp.doman.DataVo;
import com.hengtaierp.doman.MenuVo;
import com.hengtaierp.entity.SystemUser;
import com.hengtaierp.service.SystemUserService;
import com.hengtaierp.mapper.SystemUserMapper;
import com.hengtaierp.utils.JwtUtils;
import com.hengtaierp.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
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
            dataVo.error();
            dataVo.setMessage("用户或密码错误！");
            dataVo.setData(null);
            return dataVo;
        } else if (!Md5Utils.getMd5(user.getPassword()).equals(md5Password)) {
            dataVo.error();
            dataVo.setMessage("用户或密码错误！");
            dataVo.setData(null);
            return dataVo;
        }

        Map<String, Object> token = new HashMap<>();

        dataVo.ok();
        dataVo.setMessage("登录成功");
        token.put("Authorization", JwtUtils.getToken(user));


        dataVo.setData(token);


        return dataVo;
    }

    @Override
    public DataVo addUser(HttpServletRequest httpServletRequest, SystemUser systemUser) {
        DataVo dataVo = new DataVo<>();

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("account", systemUser.getAccount());
        SystemUser user = systemUserMapper.selectOne(wrapper);
        if (!Objects.isNull(user)) {

            dataVo.error();
            dataVo.setMessage("账户已存在");
            dataVo.setData(null);
            return dataVo;

        }
        int insert = systemUserMapper.insert(systemUser);
        if (insert <= 0) {
            dataVo.error();
            dataVo.setMessage("添加失败");
            dataVo.setData(null);
        }
        dataVo.ok();
        dataVo.setMessage("添加成功");
        dataVo.setData(null);

        return dataVo;
    }


}




