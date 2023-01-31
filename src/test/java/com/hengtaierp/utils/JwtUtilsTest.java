package com.hengtaierp.utils;

import com.hengtaierp.entity.SystemUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {



    @Test
    void getToken() {

        SystemUser user = new SystemUser();
        user.setId(1);
        user.setUsername("33333");
        String token = JwtUtils.getToken(user);
        System.out.println(token);

    }
}