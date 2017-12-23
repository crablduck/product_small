package com.qf.service.impl;

import java.util.List;

import com.qf.dao.IBaseDao;
import com.qf.entity.Page;
import com.qf.service.IBaseService;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {

	public abstract IBaseDao<T> getbaseDao();

	@Override
	public int add(T t) {
		// TODO Auto-generated method stub
		return getbaseDao().add(t);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return getbaseDao().delete(id);
	}

	@Override
	public int update(T t) {
		// TODO Auto-generated method stub
		return getbaseDao().update(t);
	}

	@Override
	public List<T> getList(Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return getbaseDao().getList(startIndex, pageSize);
	}

	@Override
	public T getById(Integer id) {
		// TODO Auto-generated method stub
		return getbaseDao().getById(id);
	}

	@Override
	public Page<T> getList(Page<T> page) {
		// TODO Auto-generated method stub
		Integer pageSize = page.getPageSize();

		List<T> list = getbaseDao().getList((page.getCurrentPage() - 1) * pageSize, pageSize);

		int totalCount = getbaseDao().totalCount();

		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}

		page.setTotalPage(totalPage);
		page.setList(list);
		page.setTotalCount(totalCount);
		return page;
	}

}
