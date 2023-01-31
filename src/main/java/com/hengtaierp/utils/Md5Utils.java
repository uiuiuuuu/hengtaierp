package com.hengtaierp.utils;

import org.springframework.util.DigestUtils;

public class Md5Utils {

    public static String getMd5(String password){


        return DigestUtils.md5DigestAsHex(password.getBytes());
    }






}
