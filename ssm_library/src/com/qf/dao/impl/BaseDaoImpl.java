package com.qf.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.qf.dao.IBaseDao;

/**
 * @author 谢嘉伟
 * @question: 1. 为何不能用新方法： 因为用它会写死
 * @param <T>
 */

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements IBaseDao<T> {

	private Class<?> entityClass;
	private final String BASE_PATH = "com.qf.mapper.";

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass = (Class<?>) pt.getActualTypeArguments()[0];
	}

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public int add(T t) {
		return this.getSqlSession().insert(BASE_PATH + entityClass.getSimpleName() + "Mapper.add", t);
	}

	@Override
	public int delete(Integer id) {
		return this.getSqlSession().delete(BASE_PATH + entityClass.getSimpleName() + "Mapper.delById", id);
	}

	@Override
	public int update(T t) {
		return this.getSqlSession().update(BASE_PATH + entityClass.getSimpleName() + "Mapper.update", t);
	}

	@Override
	public List<T> getList(Integer startIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		return this.getSqlSession().selectList(BASE_PATH + entityClass.getSimpleName() + "Mapper.getList", map);
	}

	@Override
	public T getById(Integer id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(BASE_PATH + entityClass.getSimpleName() + "Mapper.getById", id);
	}

	@Override
	public int totalCount() {
		return this.getSqlSession().selectOne(BASE_PATH + entityClass.getSimpleName() + "Mapper.getTotalCount");
	}

}
