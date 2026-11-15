package com.kh.movie.network;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.kh.movie.controller.MovieController;
import com.kh.movie.model.dto.MovieDto;

public class TcpServer {
	ServerSocket serverSocket = null;
	PrintWriter pw = null;
	BufferedReader br = null;
	
	public void movieConnect() {
		int portNumber = 3000;
		
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("대기중..");
			Socket socket = serverSocket.accept();
			System.out.println("연결성공");
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);

			String command = br.readLine();
			System.out.println("command: " + command);
			if ("selectAll".equals(command)) {
				MovieController mc = new MovieController();
				List<MovieDto> movieList = mc.selectAll();
				System.out.println("조회건수" + movieList.size());
				pw.println(movieList.size());
				for (MovieDto movie : movieList) {
					pw.println(movie);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		
	}
		
}
