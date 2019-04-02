package com.laurdawn.website.dao;

import java.util.List;

public interface BaseDao<T> {

//注释掉的和mybatis generator搭配
    /**
     * 根据Id查询实体
     */
	T selectEntityById(int id);
//	public T selectByPrimaryKey(int id);
	
    /**
     * 新增实体
     */
	void insertEntity(T entity);
//	public void insert(T entity);
//	public void insertSelective(T entity);
	
    /**
     * 更新实体
     */
	int updateEntityById(T entity);
//	public int updateByPrimaryKeySelective(T entity);
//	public int updateByPrimaryKey(T entity);
	
    /**
     * 根据Id删除实体
     */
	int deleteEntityById(int id);
//	public int deleteByPrimaryKey(int id);

	List<T> selectAll(T entity);

}
