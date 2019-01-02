package com.laurdawn.website.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 向mvc中添加自定义组件
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * 登录拦截器
	 */
    @Autowired
    private LoginInterceptor loginTerceptor;
    
    @Autowired
    private PermissionInterceptor permissionInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginTerceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/login", "/logout","/test");
        registry.addInterceptor(permissionInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/login", "/logout","/test");
    }

}
