package com.kh.movie.run;

import com.kh.movie.network.TcpServer;
import com.kh.movie.view.MovieView;

public class MovieRun {

	public static void main(String[] args) {
		new TcpServer().movieConnect();
		/*
		 * 지금 계획은 지금까지 만들어본 MVC+Mybatis를 서버와 클라이언트로 나눠서 해보는거
		 * 일단 연결을 수립하고
		 * 클라이언트에서 사용자에게 입력을 받고 그걸 서버로 전달
		 * ↓(여기서 입력값을 어떻게 보낼것인가가 의미임 DTO로 답아서 보내야되나? 그럼 바이트인가?)
		 * 서버는 받은 값을 server -> controller -> service -> DAO로 전달해서 result를 받는다
		 * ↓
		 * 이 결과값을 클라이언트로 보내서 클라이언트 view까지보낸다음 거기서 콘솔창에 출력할 예정
		 */

	}

}
