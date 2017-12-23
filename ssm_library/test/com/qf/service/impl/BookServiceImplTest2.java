package com.qf.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qf.dao.IBookDao;
import com.qf.entity.Book;
import com.qf.entity.Page;
import com.qf.entity.Student;
import com.qf.service.IBookService;
import com.qf.service.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookServiceImplTest2 {

	@Autowired
	private IBookService bookService;

	@Autowired
	private IBookDao bookDAO;

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testListByStu() {
		List<Book> listByStuId = bookDAO.getListByStuId(20, 0, 5);
		for (Book book : listByStuId) {
			System.out.println(book);
		}
	}

}
