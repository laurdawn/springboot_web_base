package com.laurdawn.website.entity;

/** 
* @author  laurdawn 
* @version 2019年1月2日 上午10:46:56 
*/
public class Menu {

	private Integer menuId;
	
	private String name;
	
	private Integer parentId;
	
	private String url;
	
	private Integer order;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
	
}
