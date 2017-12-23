package com.qf.dao;

import java.util.List;

public interface IBaseDao<T> {

	int add(T t);

	int delete(Integer id);

	int update(T t);

	List<T> getList(Integer startIndex, Integer pageSize);

	T getById(Integer id);

	int totalCount();

}
