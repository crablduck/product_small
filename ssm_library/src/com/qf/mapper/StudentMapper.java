package com.qf.mapper;

import java.util.List;
import java.util.Map;

import com.qf.entity.Student;

public interface StudentMapper {
	public int add(Student student);

	public int update(Student student);

	public int delById(int id);

	public Student getById(int id);

	public List<Student> getList(Map<String, Object> map);

	public int getTotalCount();
}
