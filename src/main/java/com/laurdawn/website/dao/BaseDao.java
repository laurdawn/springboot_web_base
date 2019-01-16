package com.laurdawn.website.dao;

public interface BaseDao<T> {


    /**
     * 根据Id查询实体
     */
	public T selectByPrimaryKey(int id);
	
    /**
     * 新增实体
     */
	public void insert(T entity);
	public void insertSelective(T entity);
	
    /**
     * 更新实体
     */
	public int updateByPrimaryKeySelective(T entity);
	public int updateByPrimaryKey(T entity);
	
    /**
     * 根据Id删除实体
     */
	public int deleteByPrimaryKey(int id);


}
