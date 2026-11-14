package com.kh.movie.model.service;

import java.util.List;

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

}
