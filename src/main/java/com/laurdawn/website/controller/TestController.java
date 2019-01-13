package com.laurdawn.website.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author  laurdawn 
* @version 2019年1月11日 下午4:31:24 
*/
@RestController
public class TestController {

    @RequestMapping("/test")
    private String test() {
    	return "这是test by used docker";	
    }
	
}
