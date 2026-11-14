package com.kh.movie.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.movie.model.dto.MovieDto;

public class MovieDao {

	public List<MovieDto> selectAll(SqlSession session) {
		
		return session.selectList("movieMapper.selectAll");
	}
	
}
