package com.kh.movie.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStreamReader;

public class TcpClient {
	Socket socket = null;
	BufferedReader br = null;
	PrintWriter pw = null;
	
	public void movieConnect() {
		
		try {
			socket = new Socket("127.0.0.1", 3000);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(), true);
			System.out.println("서버연결성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void selectAll() {
		pw.println("selectAll");
		try{
			int size = Integer.parseInt(br.readLine());
			for (int i = 0; i < size; i++) {
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
