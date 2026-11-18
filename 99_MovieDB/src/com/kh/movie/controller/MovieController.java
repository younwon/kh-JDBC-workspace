package com.kh.movie.controller;

import static com.kh.common.Template.getSqlSession;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.movie.model.dto.MovieDto;
import com.kh.movie.model.service.MovieService;

public class MovieController {
	MovieService ms = new MovieService();

	public List<MovieDto> selectAll() {
		return ms.selectAll();
	}
	
	public List<MovieDto> selectMovieAndReviews() {
		return ms.selectMovieAndReviews();
	}
	
	public List<MovieDto> searchByCondition(String manuNo, String keyword) {
		Map<String, String> arguments = Map.of("menuNo", manuNo, "keyword", keyword);
		
		return ms.searchByCondition(arguments);
	}
	
	public MovieDto selectOne(long id) {
		return ms.selectOne(id);
	}
	
	public int insertMovie(String name, Date date, int time, String rating) {
		MovieDto md = new MovieDto(name, date, time, rating);
		return ms.insertMovie(md);
	}
	
	public int updateTime(long id, int time) {
		MovieDto md = new MovieDto();
		md.setMovieId(id);
		md.setRunningTime(time);
		
		return ms.updateTime(md);
	}
	
	public int deleteMovie(long id) {
		return ms.deleteMovie(id);
	}

}
