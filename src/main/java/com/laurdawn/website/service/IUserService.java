package com.laurdawn.website.service;

import com.laurdawn.website.entity.User;

/**
 */
public interface IUserService {

    /**
     * 保存用户数据
     *
     * @param userVo 用户数据
     * @return 主键
     */

//    Integer insertUser(User userVo);

    /**
     * 通过uid查找对象
     * @param uid
     * @return
     */
    User queryUserById(Integer uid);

    /**
     * 用戶登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 根据主键更新user对象
     * @param userVo
     * @return
     */
    void updateByUid(User userVo);
}
