package com.qf.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.entity.Book;
import com.qf.entity.Page;
import com.qf.entity.Student;
import com.qf.service.IBookService;
import com.qf.service.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookServiceImplTest {

	@Autowired
	private IBookService bookService;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStudent() {
		Book book = new Book();
		book.setBookName("xiyouji");
		book.setPriceDouble(40.2);
		int add = bookService.add(book);

		System.out.println(add);
	}

	@Test
	public void testUpdateBook() {
		Book book = new Book();
		book.setBookName("xiaohong");
		book.setPriceDouble(20.2);
		book.setId(2);
		int add = bookService.update(book);

		System.out.println(add);
	}

	@Test
	public void testDeleteStudent() {
		Student student = new Student();
		// student.setAge(18);
		// student.setName("xiaohong");
		// student.setPassword("123321");
		// student.setId(1);
		int add = bookService.delete(1);

		System.out.println(add);
	}

	@Test
	public void testListByStu() {
		// student.setAge(18);
		// student.setName("xiaohong");
		// student.setPassword("123321");
		// student.setId(1);

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		Page<Book> page = new Page<Book>();
		Page<Book> listByStuId = bookService.getListByStuId(20, page);
		List<Book> list = page.getList();
		for (Book book : list) {
			System.out.println(book);
		}
	}

	@Test
	public void testListStudent() {
		// Student student = new Student();
		// student.setAge(18);
		// student.setName("xiaohong");
		// student.setPassword("123321");
		// student.setId(1);
		Page<Book> page = new Page<Book>();
		page = bookService.getList(page);
		List<Book> list = page.getList();
		for (Book book : list) {
			System.out.println(book);
		}
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}

}
