package com.kh.movie.run;

import com.kh.movie.network.TcpClient;
import com.kh.movie.view.MovieView;

public class Run {

	public static void main(String[] args) {
		TcpClient tc = new TcpClient();
		tc.movieConnect();
		new MovieView(tc).mainMenu();

	}

}
