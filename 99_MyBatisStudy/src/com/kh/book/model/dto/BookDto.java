package com.kh.book.model.dto;

/** 도서 한 권의 정보를 전달하기 위한 DTO입니다. */
public class BookDto {
	private int bookNo;
	private String title;
	private String author;
	private int price;

	public BookDto() {
	}

	public BookDto(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public BookDto(int bookNo, String title, String author, int price) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDto [bookNo=" + bookNo + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
}
