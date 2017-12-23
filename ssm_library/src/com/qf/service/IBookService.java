package com.qf.service;

import java.util.List;

import com.qf.entity.Book;
import com.qf.entity.Page;

public interface IBookService extends IBaseService<Book> {

	public Page<Book> getListByStuId(Integer id, Page<Book> page);
}
