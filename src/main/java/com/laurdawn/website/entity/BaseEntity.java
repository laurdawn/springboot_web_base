package com.laurdawn.website.entity;

/** 
* @author  laurdawn 
* @version 2019年1月2日 上午10:05:12 
*/
public class BaseEntity {
	
	private Integer pageNum = 0;
	
	private Integer pageSize = 10;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
