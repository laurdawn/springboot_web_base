package com.laurdawn.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laurdawn.website.utils.RedisUtil;

/** 
* @author  laurdawn 
* @version 2019年1月11日 下午4:31:24 
*/
@RestController
public class RedisController {
	
//	@Resource
//	private RedisTemplate<String, String> redisTemplate;
	
	@Autowired
	private RedisUtil redisUtil;

    @RequestMapping("/test")
    private String test() {
    	redisUtil.lLeftPushAll("test", "1", "2");
//    	redisTemplate.opsForList().leftPushAll("test", "1", "2");
    	return "hello word!";	
    }
	
}
