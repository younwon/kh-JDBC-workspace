package com.kh.book.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.book.model.dao.BookDao;
import com.kh.book.model.dto.BookDto;
import com.kh.common.Template;

public class BookService {
	
	public int insertBook(BookDto bd) {
		SqlSession session = Template.getSqlSession();
		int result = new BookDao().insertBook(session, bd);
		session.close();
		
		return result;
	}

	public List<BookDto> selectAll() {
		SqlSession session = Template.getSqlSession();
		List<BookDto> books = new BookDao().selectAll(session);
		session.close();
		return books;

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
