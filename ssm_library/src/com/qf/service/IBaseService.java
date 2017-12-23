package com.qf.service;

import java.util.List;

import com.qf.entity.Page;

public interface IBaseService<T> {

	int add(T t);

	int delete(Integer id);

	int update(T t);

	List<T> getList(Integer startIndex, Integer pageSize);

	Page<T> getList(Page<T> page);

	T getById(Integer id);

}
