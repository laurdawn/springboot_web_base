package com.laurdawn.website.entity;

/** 
* @author  laurdawn 
* @version 2019年1月2日 上午11:51:26 
*/
public class Role extends BaseEntity{

	private Integer id;
	
	private String roleName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
