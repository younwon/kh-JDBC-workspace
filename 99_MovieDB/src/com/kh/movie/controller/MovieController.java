package com.kh.movie.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
