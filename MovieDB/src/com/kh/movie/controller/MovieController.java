package com.kh.movie.controller;

import java.util.List;

import com.kh.movie.model.dto.MovieDto;
import com.kh.movie.model.service.MovieService;

public class MovieController {
	MovieService ms = new MovieService();

	public List<MovieDto> selectAll() {
		return ms.selectAll();
		
	}

}
