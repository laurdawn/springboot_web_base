package com.laurdawn.website.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laurdawn.website.dao.UserDao;
import com.laurdawn.website.entity.User;
import com.laurdawn.website.exception.TipException;
import com.laurdawn.website.service.IUserService;
import com.laurdawn.website.utils.TaleUtils;

@Service
public class UserServiceImpl implements IUserService {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    /**
     * 通过id查询用户
     */
    @Override
    public User queryUserById(Integer id) {
    	User user = null;
        if (id != null) {
            user = userDao.selectEntityById(id);
        }
        return user;
    }

    /**
     * 手机号密码认证
     */
    @Override
    public User login(String phone, String password) {
        if (StringUtils.isBlank(phone) || StringUtils.isBlank(password)) {
            throw new TipException("phone or password is not null.");
        }
        User user = userDao.selectUserByPhone(phone);
        if (user == null) {
            throw new TipException("this user is no exist.");
        }
        String pwd = TaleUtils.MD5encode(password);
        if(!password.equals(pwd)) {
        	throw new TipException("this user password is error.");
        }
        return user;
    }

    /**
     * 通过id修改用户信息
     */
    @Override
    @Transactional
    public void updateById(User user) {
        if (null == user || null == user.getId()) {
            throw new TipException("user is null");
        }
        int i = userDao.updateEntityById(user);
        if (i != 1) {
            throw new TipException("update user by id and retrun is not one");
        }
    }

    /**
     * 注册并保存用户信息
     */
	@Override
	@Transactional
	public Integer saveUser(User user) {
        if (StringUtils.isNotBlank(user.getPhone()) && StringUtils.isNotBlank(user.getPassword())) {
        	//md5加密
            String encodePwd = TaleUtils.MD5encode(user.getPassword());
            user.setPassword(encodePwd);
            userDao.insertEntity(user);
        } else {
        	throw new TipException("phone or password is null.");
        }
        return user.getId();
	}
	
	@Override
	public List<User> findAll(User user){
		return userDao.selectAll(user);
	}
}
