package com.laurdawn.website.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laurdawn.website.dao.RoleDao;
import com.laurdawn.website.dao.RoleMenuDao;
import com.laurdawn.website.entity.Role;
import com.laurdawn.website.service.IRoleService;

/** 
* @author  laurdawn 
* @version 2019年1月2日 下午1:50:03 
*/
@Service
public class RoleServiceImpl implements IRoleService{
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RoleMenuDao roleMenuDao;

	/**
	 * 通过id查询角色
	 */
	@Override
	public Role findById(int id) {
		return roleDao.selectEntityById(id);
	}

	/**
	 * 查询所有角色
	 */
	@Override
	public PageInfo<Role> findAllRole(Role entity) {
//		PageHelper.startPage(1, 10);
		List<Role> list = roleDao.selectAll(entity);
		PageInfo<Role> page = new PageInfo<Role>(list);
		return page;
	}

	/**
	 * 保存角色
	 */
	@Override
	@Transactional
	public void saveRole(Role entity) {
		roleDao.insertEntity(entity);
	}

	/**
	 * 修改角色名称
	 */
	@Override
	@Transactional
	public void modifyRole(Role entity) {
		roleDao.updateEntityById(entity);
	}

	/**
	 * 删除角色
	 */
	@Override
	@Transactional
	public void deleteRole(int id) {
		//删除角色
		roleDao.deleteEntityById(id);
		//同时删除该角色权限
		roleMenuDao.deleteRolePermissionByRoleId(id);
	}

}
