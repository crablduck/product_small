package com.qf.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.entity.Page;
import com.qf.entity.Student;
import com.qf.service.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudentServiceImplTest {

	@Autowired
	private IStudentService studentService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setAge(18);
		student.setName("xiaoming");
		student.setPassword("123321");
		int add = studentService.add(student);

		System.out.println(add);
	}

	@Test
	public void testUpdateStudent() {
		Student student = new Student();
		student.setAge(18);
		student.setName("xiaohong");
		student.setPassword("123321");
		student.setId(1);
		int add = studentService.update(student);

		System.out.println(add);
	}

	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		// student.setAge(18);
		// student.setName("xiaohong");
		// student.setPassword("123321");
		// student.setId(1);
		int add = studentService.delete(1);

		System.out.println(add);
	}

	@Test
	public void testByIdStudent() {
		Student student = new Student();
		// student.setAge(18);
		// student.setName("xiaohong");
		// student.setPassword("123321");
		// student.setId(1);
		Student byId = studentService.getById(20);

		System.out.println(byId);
	}

	@Test
	public void testListStudent() {
		Student student = new Student();
		// student.setAge(18);
		// student.setName("xiaohong");
		// student.setPassword("123321");
		// student.setId(1);
		Page<Student> page = new Page<Student>();
		page = studentService.getList(page);
		List<Student> list = page.getList();
		for (Student student2 : list) {
			System.out.println(student2);
		}
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}

}
