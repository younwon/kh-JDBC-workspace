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
	
	public MovieDto selectOne(SqlSession session, long id) {
		return session.selectOne("movieMapper.selectOne", id);
	}
	
	public int insertMovie(SqlSession session, MovieDto md) {
		return session.insert("movieMapper.insertMovie", md);
	}
	
	public int updateTIme(SqlSession session, MovieDto md) {
		return session.update("movieMapper.updateTime", md);
	}
	
	public int deleteMovie(SqlSession session, long id) {
		return session.delete("movieMapper.deleteMovie", id);
	}
	
}
