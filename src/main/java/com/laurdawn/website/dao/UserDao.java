package com.laurdawn.website.dao;

import org.springframework.stereotype.Component;

import com.laurdawn.website.entity.User;

@Component
public interface UserDao extends BaseDao<User>{
	
	User selectUserByPhone(String phone);
	
}