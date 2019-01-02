package com.laurdawn.website.entity;

import java.util.List;

/** 
* @author  laurdawn 
* @version 2019年1月2日 上午10:50:07 
*/
public class RoleMenu {

	private Integer id;
	
	private Integer RoleId;
	
	private String roleName;
	
	private Integer MenuId;
	
	private List<Menu> Menu;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public Integer getMenuId() {
		return MenuId;
	}

	public void setMenuId(Integer menuId) {
		MenuId = menuId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Menu> getMenu() {
		return Menu;
	}

	public void setMenu(List<Menu> menu) {
		Menu = menu;
	}
	
}
