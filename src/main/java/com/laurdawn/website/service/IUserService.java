package com.laurdawn.website.service;

import java.util.List;

import com.laurdawn.website.entity.User;

public interface IUserService {

    /**
     * 保存用户数据
     *
     * @param userVo 用户数据
     * @return 主键
     */

    Integer saveUser(User user);

    /**
     * 通过id查找对象
     * @param id
     * @return
     */
    User queryUserById(Integer id);

    /**
     * 用戶登录
     * @param username
     * @param password
     * @return
     */
    User login(String phone, String password);

    /**
     * 根据主键更新user对象
     * @param user
     * @return
     */
    void updateById(User user);

	List<User> findAll(User user);
}
