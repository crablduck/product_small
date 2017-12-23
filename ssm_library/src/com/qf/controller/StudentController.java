package com.qf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.entity.Page;
import com.qf.entity.Student;
import com.qf.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping("/hello")
	public String hello() {
		return "ok";
	}

	@RequestMapping("/page/{currentPage}")
	public String page(@PathVariable Integer currentPage, ModelMap map) {
		Page<Student> page = new Page<Student>();
		if (currentPage != null) {
			page.setCurrentPage(currentPage);
		}
		page = studentService.getList(page);
		page.setUrl("student/page");
		map.put("page", page);
		return "stuList";
	}

	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		studentService.add(student);
		return "redirect: page/1";
	}

	@RequestMapping("/toUpdate/{id}")
	public String toUpdate(@PathVariable Integer id, ModelMap map) {
		Student byId = studentService.getById(id);
		map.put("student", byId);
		return "update";
	}

	@RequestMapping("/updateStudent")
	public String updateStudent(Student student) {
		studentService.update(student);
		return "redirect: page/1";
	}

	@RequestMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentService.delete(id);
		return "redirect: ../page/1";
	}
}
