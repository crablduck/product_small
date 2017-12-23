package com.qf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.dao.IBaseDao;
import com.qf.dao.IStudentDao;
import com.qf.entity.Student;
import com.qf.service.IStudentService;

@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	@Override
	public IBaseDao<Student> getbaseDao() {
		// TODO Auto-generated method stub
		return studentDao;
	}

}
