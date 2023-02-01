package com.hengtaierp.service.impl;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hengtaierp.doman.HomeVo;
import com.hengtaierp.doman.LogoVo;
import com.hengtaierp.doman.MenuVo;
import com.hengtaierp.entity.SystemMenu;
import com.hengtaierp.entity.SystemRole;
import com.hengtaierp.mapper.SystemMenuMapper;
import com.hengtaierp.mapper.SystemRoleMapper;
import com.hengtaierp.service.SystemMenuService;
import com.hengtaierp.utils.JwtUtils;
import com.hengtaierp.utils.TreeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemMenuServiceImpl implements SystemMenuService {


    @Resource
    private SystemMenuMapper systemMenuMapper;

    @Resource
    private SystemRoleMapper systemRoleMapper;


    @Override
    public MenuVo menu(HttpServletRequest httpServletRequest) {

        String authorization = httpServletRequest.getHeader("Authorization");
        DecodedJWT verify = JwtUtils.verify(authorization);
        Claim claim = verify.getClaim("id");
        int i = claim.asInt().intValue();
        MenuVo menu = new MenuVo();

        QueryWrapper wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", i);
        List<SystemRole> menuList = systemRoleMapper.selectList(wrapper);
        List<SystemMenu> menuInfo = new ArrayList<>();
        QueryWrapper queryWrapper = new QueryWrapper<>();
        for (SystemRole e : menuList) {
            long menuId = e.getMenuId();
            queryWrapper.eq("id", menuId);
            SystemMenu systemMenu = systemMenuMapper.selectOne(queryWrapper);
            menuInfo.add(systemMenu);

        }
        menu.setMenuInfo(TreeUtil.toTree(menuInfo, 0L));

        HomeVo homeVo = new HomeVo();
        homeVo.setTitle("首页");
        homeVo.setHref("/page/welcome-1");
        LogoVo logoVo = new LogoVo();
        logoVo.setTitle("HENG TAI");
        logoVo.setImage("images/logo.png");
        menu.setHomeInfo(homeVo);
        menu.setLogoInfo(logoVo);


        menu.setCode(0);
        menu.setMessage("菜单获取成功");


        return menu;
    }
}


