package com.kh.book.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.book.model.dto.BookDto;

public class BookDao {
	
	public int insertBook(SqlSession session, BookDto bd) {
		
		return session.insert("bookMapper.insertBook", bd);
	}
	
	public List<BookDto> selectAll(SqlSession session) {
		return session.selectList("bookMapper.selectAll");
	}

}
