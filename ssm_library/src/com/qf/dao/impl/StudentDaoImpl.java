package com.qf.dao.impl;

import org.springframework.stereotype.Repository;

import com.qf.dao.IStudentDao;
import com.qf.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student> implements IStudentDao {

}
