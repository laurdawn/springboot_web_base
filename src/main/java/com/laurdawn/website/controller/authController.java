package com.laurdawn.website.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurdawn.website.utils.TaleUtils;

/**
 * 登录
 */
@RestController
public class authController extends BaseController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(authController.class);

    
    @RequestMapping("/test")
    private String test() {
    	return "这是hello world";	
    }
    
//    @GetMapping("/login")
//    public void login(){
//    	
//    }
    
    /**
     * 注销
     *
     * @param session
     * @param response
     */
    @RequestMapping("logout")
    public void logout(HttpSession session, HttpServletResponse response) {
        TaleUtils.logout(session, response);
    }

}
