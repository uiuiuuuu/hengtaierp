//package com.hengtaierp.service.impl;
//
//import com.hengtaierp.doman.DataVo;
//import com.hengtaierp.service.SystemMenuService;
//
//import javax.annotation.Resource;
//
//public class SystemMenuServiceImpl implements SystemMenuService {
//
//    @Resource
//    private s sysMenuRepository;
//    @Override
//    public DataVo menu() {
//
//        @Override
//        public Map<String, Object> menu() {
//            Map<String, Object> map = new HashMap<>(16);
//            Map<String,Object> home = new HashMap<>(16);
//            Map<String,Object> logo = new HashMap<>(16);
//            List<SysMenu> menuList = sysMenuRepository.findAllByStatusOrderBySort(true);
//            List<MenuVo> menuInfo = new ArrayList<>();
//            for (SysMenu e : menuList) {
//                MenuVo menuVO = new MenuVo();
//                menuVO.setId(e.getKey().getId());
//                menuVO.setPid(e.getPid());
//                menuVO.setHref(e.getKey().getHref());
//                menuVO.setTitle(e.getKey().getTitle());
//                menuVO.setIcon(e.getIcon());
//                menuVO.setTarget(e.getTarget());
//                menuInfo.add(menuVO);
//            }
//            map.put("menuInfo", TreeUtil.toTree(menuInfo, 0L));
//            home.put("title","首页");
//            home.put("href","/page/welcome-1");//控制器路由,自行定义
//            logo.put("title","后台管理系统");
//            logo.put("image","/static/images/back.jpg");//静态资源文件路径,可使用默认的logo.png
//            map.put("homeInfo", "{title: '首页',href: '/ruge-web-admin/page/welcome.html'}}");
//            map.put("logoInfo", "{title: 'RUGE ADMIN',image: 'images/logo.png'}");
//            return map;
//        }
//    }
//        return null;
//    }
//}
