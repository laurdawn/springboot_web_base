package com.laurdawn.website.config;


import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.laurdawn.website.interceptor.LoginInterceptor;
import com.laurdawn.website.interceptor.PermissionInterceptor;

/**
 * 向mvc中添加自定义组件
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
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
    
    @Bean
    public HttpMessageConverter<String> responseBodyStringConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(responseBodyStringConverter());
    }

}
