package com.hengtaierp.service.impl;

import com.hengtaierp.doman.DataVo;
import com.hengtaierp.entity.SystemMenu;
import com.hengtaierp.mapper.SystemMenuMapper;
import com.hengtaierp.mapper.SystemRoleMapper;
import com.hengtaierp.service.SystemMenuService;
import com.hengtaierp.utils.TreeUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemMenuServiceImpl implements SystemMenuService, HandlerInterceptor {


    @Resource
    private SystemMenuMapper systemMenuMapper;

    @Resource
    private SystemRoleMapper systemRoleMapper;


    @Override
    public Map<String, Object> menu() {


        DataVo dataVo = new DataVo<>();


        Map<String, Object> map = new HashMap<>(16);
        Map<String, Object> home = new HashMap<>(16);
        Map<String, Object> logo = new HashMap<>(16);
        List<SystemMenu> menuList = systemMenuMapper.selectList(null);
        List<SystemMenu> menuInfo = new ArrayList<>();
        for (SystemMenu e : menuList) {
            SystemMenu systemMenu = new SystemMenu();
            systemMenu.setId(e.getId());
            systemMenu.setPid(e.getPid());
            systemMenu.setHref(e.getHref());
            systemMenu.setTitle(e.getTitle());
            systemMenu.setIcon(e.getIcon());
            systemMenu.setTarget(e.getTarget());
            menuInfo.add(systemMenu);
        }

        map.put("menuInfo", TreeUtil.toTree(menuInfo, 0L));


        home.put("title", "首页");
        home.put("href", "/page/welcome-1");//控制器路由,自行定义
        logo.put("title", "后台管理系统");
        logo.put("image", "/static/images/back.jpg");//静态资源文件路径,可使用默认的logo.png
        map.put("homeInfo", "{title: '首页',href: '/ruge-web-admin/page/welcome.html'}}");
        map.put("logoInfo", "{title: 'RUGE ADMIN',image: 'images/logo.png'}");

        return map;
    }
}


