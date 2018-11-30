package com.laurdawn.website.constant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class WebConst {
    public static Map<String, String> initConfig = new HashMap<>();


    public static String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "TOOTOO8_ID";

    /**
     * aes加密加盐
     */
    public static String AES_SALT = "0123456789abcdef";

}
