package com.kh.movie.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.movie.model.dto.MovieDto;

public class MovieDao {

	public List<MovieDto> selectAll(SqlSession session) {
		
		return session.selectList("movieMapper.selectAll");
	}
	
	public List<MovieDto> selectMovieAndReviews(SqlSession session) {
		System.out.println("dao도착");
		return session.selectList("movieMapper.selectMoviewAndReviews");
	}
	
	public List<MovieDto> searchByCondition(SqlSession session, Map<String, String> arguments) {
		return session.selectList("movieMapper.searchByCondition", arguments);
	}
	
}
