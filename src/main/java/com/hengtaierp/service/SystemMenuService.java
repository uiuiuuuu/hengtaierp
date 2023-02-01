package com.hengtaierp.service;

import com.hengtaierp.doman.DataVo;
import com.hengtaierp.doman.MenuVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SystemMenuService {
    MenuVo menu(HttpServletRequest httpServletRequest);
}
