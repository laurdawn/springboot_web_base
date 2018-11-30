package com.laurdawn.website.service.impl;

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

/**
 * Created by BlueT on 2017/3/3.
 */
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

//    @Override
//    @Transactional
//    public Integer insertUser(User userVo) {
//        Integer uid = null;
//        if (StringUtils.isNotBlank(userVo.getUsername()) && StringUtils.isNotBlank(userVo.getEmail())) {
////            用户密码加密
//            String encodePwd = TaleUtils.MD5encode(userVo.getUsername() + userVo.getPassword());
//            userVo.setPassword(encodePwd);
////            userDao.insertSelective(userVo);
//        }
//        return userVo.getUid();
//    }

    @Override
    public User queryUserById(Integer uid) {
    	User userVo = null;
        if (uid != null) {
//            userVo = userDao.selectByPrimaryKey(uid);
        }
        return userVo;
    }

    @Override
    public User login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
//        UserVoExample example = new UserVoExample();
//        UserVoExample.Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo(username);
//        long count = userDao.countByExample(example);
//        if (count < 1) {
//            throw new TipException("不存在该用户");
//        }
//        String pwd = TaleUtils.MD5encode(username + password);
//        criteria.andPasswordEqualTo(pwd);
//        List<UserVo> userVos = userDao.selectByExample(example);
//        if (userVos.size() != 1) {
//            throw new TipException("用户名或密码错误");
//        }
//        return userVos.get(0);
        return null;
    }

    @Override
    @Transactional
    public void updateByUid(User userVo) {
        if (null == userVo || null == userVo.getUid()) {
            throw new TipException("userVo is null");
        }
//        int i = userDao.updateByPrimaryKeySelective(userVo);
//        if (i != 1) {
//            throw new TipException("update user by uid and retrun is not one");
//        }
    }
}
