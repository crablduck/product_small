package com.qf.dao;

import java.util.List;
import java.util.Map;

import com.qf.entity.Book;

public interface IBookDao extends IBaseDao<Book> {
	public List<Book> getListByStuId(Integer id, Integer startIndex, Integer pageSize);
}
