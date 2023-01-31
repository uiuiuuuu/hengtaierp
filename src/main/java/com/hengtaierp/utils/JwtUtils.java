package com.hengtaierp.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hengtaierp.entity.SystemUser;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtUtils {

    //签名秘钥
    private static final String STRING = "y@3Km(ld*qn^l";
    private static final String ISSUER= "fanxihui";
    public static String getToken(SystemUser systemUser){

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,1);
        String token = JWT.create()
                .withIssuer(ISSUER)
                .withClaim("username", systemUser.getUsername())
                .withClaim("id", systemUser.getId())
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(STRING));
        return token;
    }

    public static DecodedJWT verify(String token){

        DecodedJWT verify = JWT.require(Algorithm.HMAC256(STRING)).build().verify(token);

        return verify;

    }

}
