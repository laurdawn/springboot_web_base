package com.laurdawn.website.controller;

import javax.servlet.http.HttpServletRequest;

import com.laurdawn.website.entity.User;
import com.laurdawn.website.utils.TaleUtils;

public abstract class BaseController {

    /**
     * 获取请求绑定的登录对象
     * @param request
     * @return
     */
    public User user(HttpServletRequest request) {
        return TaleUtils.getLoginUser(request);
    }

    public Integer getUid(HttpServletRequest request){
        return this.user(request).getUid();
    }

    public String return_error() {
//    	TODO
        return "error";
    }

}
