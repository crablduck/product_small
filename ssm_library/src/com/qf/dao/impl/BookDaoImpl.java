package com.qf.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qf.dao.IBookDao;
import com.qf.entity.Book;

@Repository("bookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements IBookDao {

	@Override
	public List<Book> getListByStuId(Integer id, Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		map.put("id", id);
		return this.getSqlSession().selectList("com.qf.mapper.BookMapper.getListByStuId", map);
	}

}
