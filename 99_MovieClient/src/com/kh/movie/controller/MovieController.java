package com.kh.movie.controller;

import com.kh.movie.network.TcpClient;

public class MovieController {
	TcpClient tc;

	public MovieController(TcpClient tc) {
		this.tc = tc;
	}

	public void selectAll() {
		tc.selectAll();
	}

	public void selectMovieAndReviews() {
		
	}
}
