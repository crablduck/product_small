package com.qf.entity;

public class Book {

	private Integer id;
	private String bookName;
	private Double priceDouble;

	private Student student;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Double getPriceDouble() {
		return priceDouble;
	}

	public void setPriceDouble(Double priceDouble) {
		this.priceDouble = priceDouble;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", priceDouble=" + priceDouble + ", student=" + student
				+ "]";
	}

}
