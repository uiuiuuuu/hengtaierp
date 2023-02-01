package com.hengtaierp.config;

import com.hengtaierp.interceptor.JWTInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class JwtWebMvcConfig implements WebMvcConfigurer {

    private String api = "/api/user";
    String[] art = {
            api + "/login",
            api + "/upload"
    };

    String[] out = {
            api + "/test"

    };


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns(out) //添加拦截路径
                .excludePathPatterns(art);//跳过哪个路径，以实际项目为准
    }
}
