package com.hengtaierp.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hengtaierp.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//拦截器
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        Map<String,Object> map = new HashMap<>();
        try {
            JwtUtils.verify(token);
            return true;
        } catch (TokenExpiredException e) {
            map.put("state", false);
            map.put("code",3);
            map.put("msg", "登录已过期,请重新登录！");
        } catch (SignatureVerificationException e){
            map.put("state", false);
            map.put("code",4);
            map.put("msg", "验证错误,请确认后登录");
        } catch (AlgorithmMismatchException e){
            map.put("state", false);
            map.put("msg", "加密错误");
            map.put("code",6);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("code",5);
            map.put("msg", "验证无效");
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}



