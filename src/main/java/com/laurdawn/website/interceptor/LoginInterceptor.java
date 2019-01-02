package com.laurdawn.website.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.laurdawn.website.constant.WebConst;
import com.laurdawn.website.dto.Types;
import com.laurdawn.website.entity.User;
import com.laurdawn.website.service.IUserService;
import com.laurdawn.website.utils.IPKit;
import com.laurdawn.website.utils.MapCache;
import com.laurdawn.website.utils.TaleUtils;
import com.laurdawn.website.utils.UUID;

/**
 * 自定义拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger Logging = LoggerFactory.getLogger(LoginInterceptor.class);
    private static final String USER_AGENT = "user-agent";

    @Resource
    private IUserService userService;

//    @Resource
//    private IOptionService optionService;

    private MapCache cache = MapCache.single();

//    @Resource
//    private AdminCommons adminCommons;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String contextPath = request.getContextPath();
        // System.out.println(contextPath);
        String uri = request.getRequestURI();

        Logging.info("UserAgent: {}", request.getHeader(USER_AGENT));
        Logging.info("用户访问地址: {}, 来路地址: {}", uri, IPKit.getIpAddrByRequest(request));


        //请求拦截处理
        User user = TaleUtils.getLoginUser(request);
        if (null == user) {
            Integer id = TaleUtils.getCookieId(request);
            if (null != id) {
                //这里还是有安全隐患,cookie是可以伪造的
                user = userService.queryUserById(id);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            } else {
            	return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        OptionVo ov = optionService.getOptionByName("site_record");
//        httpServletRequest.setAttribute("option", ov);
//        httpServletRequest.setAttribute("adminCommons", adminCommons);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
