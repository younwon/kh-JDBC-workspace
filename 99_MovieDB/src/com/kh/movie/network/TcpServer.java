package com.kh.movie.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public void movieConnect() {
		ServerSocket serverSocket = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		
		int portNumber = 3000;
		
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("대기중..");
			Socket socket = serverSocket.accept();
			System.out.println("연결성공");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
