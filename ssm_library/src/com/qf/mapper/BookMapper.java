package com.qf.mapper;

import java.util.List;
import java.util.Map;

import com.qf.entity.Book;

public interface BookMapper {
	public int add(Book book);

	public int update(Book book);

	public int delById(int id);

	public Book getById(int id);

	public List<Book> getList(Map<String, Object> map);

	public List<Book> getListByStuId(Map<String, Object> map);

	public int getTotalCount();
}
