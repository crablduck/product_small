package com.qf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.IBookDao;
import com.qf.entity.Book;
import com.qf.entity.Page;
import com.qf.service.IBookService;

@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl<Book> implements IBookService {

	@Autowired
	private IBookDao bookDao;

	@Override
	public IBaseDao<Book> getbaseDao() {
		// TODO Auto-generated method stub
		return bookDao;
	}

	@Override
	public Page<Book> getListByStuId(Integer id, Page<Book> page) {
		// TODO Auto-generated method stub
		Integer pageSize = page.getPageSize();

		List<Book> list = bookDao.getListByStuId(id, page.getCurrentPage(), pageSize);
		int totalCount = bookDao.totalCount();

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
