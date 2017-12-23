package com.qf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qf.entity.Book;
import com.qf.entity.Page;
import com.qf.service.IBookService;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private IBookService bookService;

	@RequestMapping("page/{currentPage}")
	public String page(@PathVariable Integer currentPage, ModelMap map) {
		Page<Book> page = new Page<Book>();
		if (currentPage != null) {
			page.setCurrentPage(currentPage);
		}
		page = bookService.getList(page);
		page.setUrl("book/page");
		map.put("page", page);
		return "bookList";
	}

	@RequestMapping("/addBook")
	public String addBook(Book book) {
		bookService.add(book);
		return "redirect: page/1";
	}

	@RequestMapping("/booksByStu/{id}/{currentPage}")
	public String booksByStu(@PathVariable Integer id, @PathVariable Integer currentPage, ModelMap map) {
		Page<Book> page = new Page<Book>();
		if (currentPage != null) {
			page.setCurrentPage(currentPage);
		}
		page = bookService.getListByStuId(id, page);
		page.setUrl("book/booksByStu/" + id);
		map.put("page", page);
		return "bookList";
	}

	@RequestMapping("/toUpdate/{id}")
	public String toUpdate(@PathVariable Integer id, ModelMap map) {
		Book byId = bookService.getById(id);
		map.put("book", byId);
		return "updateBook";
	}

	@RequestMapping("/updateBook")
	public String updateBook(Book book) {
		bookService.update(book);
		return "redirect: page/1";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookService.delete(id);
		return "redirect: ../page/1";
	}

}
