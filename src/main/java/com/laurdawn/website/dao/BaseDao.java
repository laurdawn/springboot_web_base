package com.laurdawn.website.dao;

import java.util.List;

public interface BaseDao<T> {


    /**
     * 根据Id查询实体
     */
    public T selectEntityById(int id);

    /**
     * 新增实体
     */
    public void insertEntity(T entity);

    /**
     * 更新实体
     */
    public int updateEntityById(T entity);

    /**
     * 根据Id删除实体
     */
    public int deleteEntityById(int id);

    /**
     * 查询全部
     */
    public List<T> selectAll();


}
