package com.kh.book.model.service;

import java.util.List;

import com.kh.book.model.dto.BookDto;

public class BookService {
	
	public int insertBook(BookDto bd) {
		int result = 0;
		
		return 0;
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
