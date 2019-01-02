package com.laurdawn.website.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.laurdawn.website.dao.RoleMenuDao;
import com.laurdawn.website.entity.Menu;
import com.laurdawn.website.entity.RoleMenu;
import com.laurdawn.website.entity.User;
import com.laurdawn.website.utils.TaleUtils;

/**
 * 用户权限拦截器
 */
@Component
public class PermissionInterceptor implements HandlerInterceptor {
	
    private static final Logger Logging = LoggerFactory.getLogger(PermissionInterceptor.class);
    
    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
    	User user = TaleUtils.getLoginUser(request);
    	if(user == null) {
    		return false;
    	}
    	RoleMenu userRoleMenu = roleMenuDao.selectRolePermissionByRoleId(user.getRoleId());
    	String uri = request.getRequestURI();
    	for(Menu menu: userRoleMenu.getMenu()) {
    		if(menu.getUrl().equals(uri)) {
    			return true;
    		}
    	}
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
