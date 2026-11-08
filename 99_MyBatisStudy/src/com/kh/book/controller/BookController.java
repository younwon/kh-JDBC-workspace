package com.kh.book.controller;

import java.util.List;

import com.kh.book.model.dto.BookDto;
import com.kh.book.model.service.BookService;

/**
 * View와 Service 사이를 연결하는 Controller 자리입니다.
 *
 * TODO: 학습하면서 BookService를 만들고 각 메소드에서 Service를 호출하도록 구현하세요.
 */
public class BookController {
	BookService bs = new BookService();

	public int insertBook(String title, String author, int price) {
		BookDto bd = new BookDto(title, author, price);
		
		return bs.insertBook(bd);
	}

	public List<BookDto> selectAll() {
		throw new UnsupportedOperationException("selectAll을 구현하세요.");
	}

	public BookDto selectByNo(int bookNo) {
		throw new UnsupportedOperationException("selectByNo를 구현하세요.");
	}

	public int updateBook(int bookNo, String title, String author, int price) {
		throw new UnsupportedOperationException("updateBook을 구현하세요.");
	}

	public int deleteBook(int bookNo) {
		throw new UnsupportedOperationException("deleteBook을 구현하세요.");
	}
}
