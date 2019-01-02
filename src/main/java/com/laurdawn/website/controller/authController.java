package com.laurdawn.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurdawn.website.entity.User;
import com.laurdawn.website.enums.EResultType;
import com.laurdawn.website.service.IUserService;
import com.laurdawn.website.utils.TaleUtils;

/**
 * 登录
 */
@RestController
public class AuthController extends BaseController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private IUserService userService;
    
    @RequestMapping("/test")
    private String test() {
    	return "这是test";	
    }
    
    @GetMapping("/login")
    public String login(User entity, HttpServletRequest request, HttpServletResponse response){
    	if(getId(request) == null) {
    		return retResultData(EResultType.NOT_FOUND);
    	}
    	User user = userService.login(entity.getPhone(), entity.getPassword());
    	TaleUtils.setCookie(response, user.getId());
    	return retResultData(EResultType.SUCCESS);
    }
    
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
