package com.kh.movie.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import static com.kh.common.Template.getSqlSession;
import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.dto.MovieDto;

public class MovieService {
	MovieDao ma = new MovieDao();
	
	public List<MovieDto> selectAll() {
		SqlSession session = getSqlSession();
		List<MovieDto> list = ma.selectAll(session);
		session.close();
		return list;
	}
	
	public List<MovieDto> selectMovieAndReviews() {
		System.out.println("서비스도착");
		SqlSession session = getSqlSession();
		List<MovieDto> list = ma.selectMovieAndReviews(session);
		session.close();
		return list;
	}
	
	public List<MovieDto> searchByCondition(Map<String, String> arguments) {
		SqlSession session = getSqlSession();
		List<MovieDto> list = ma.searchByCondition(session, arguments);
		session.close();
		return list;
	}
	
	public MovieDto selectOne(long id) {
		SqlSession session = getSqlSession();
		MovieDto md = ma.selectOne(session, id);
		session.close();
		return md;
	}
	
	public int insertMovie(MovieDto md) {
		SqlSession session = getSqlSession();
		int result = ma.insertMovie(session, md);
		session.close();
		return result;
	}
	
	public int updateTime(MovieDto md) {
		SqlSession session = getSqlSession();
		int result = ma.updateTIme(session, md);
		session.close();
		return result;
	}
	
	public int deleteMovie(long id) {
		SqlSession session = getSqlSession();
		int result = ma.deleteMovie(session, id);
		session.close();
		return result;
	}

}
