package com.laurdawn.website.dao;

import org.springframework.stereotype.Component;

import com.laurdawn.website.entity.Menu;
import com.laurdawn.website.entity.RoleMenu;

/** 
* @author  laurdawn 
* @version 2019年1月2日 上午10:46:29 
*/
@Component
public interface RoleMenuDao extends BaseDao<Menu>{
	
	RoleMenu selectRolePermissionByRoleId(int id);

	void deleteRolePermissionByRoleId(int roleId);
	
}
