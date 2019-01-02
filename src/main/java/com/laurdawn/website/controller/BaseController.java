package com.laurdawn.website.controller;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.laurdawn.website.entity.Result;
import com.laurdawn.website.entity.User;
import com.laurdawn.website.enums.EResultType;
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

    public Integer getId(HttpServletRequest request){
        return this.user(request).getId();
    }
    
    @SuppressWarnings("rawtypes")
	protected String retResultData(EResultType type) {
        return JSON.toJSONString(new Result(type));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	protected String retResultData(EResultType type, Object data) {
        return JSON.toJSONString(new Result(type, data));
    }

    @SuppressWarnings("rawtypes")
	protected String retResultData(Integer code, String message) {
        return JSON.toJSONString(new Result(code, message));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected String retResultData(Integer code, String message, Object data) {
        return JSON.toJSONString(new Result(code, message, data));
    }

}
