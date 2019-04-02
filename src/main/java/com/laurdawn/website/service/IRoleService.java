package com.laurdawn.website.service;

import com.github.pagehelper.PageInfo;
import com.laurdawn.website.entity.Role;

/** 
* @author  laurdawn 
* @version 2019年1月2日 下午1:42:12 
*/
public interface IRoleService {

	Role findById(int id);
	
	void saveRole(Role entity);
	
	void modifyRole(Role entity);
	
	void deleteRole(int id);

	PageInfo<Role> findAllRole(Role entity);
	
}
