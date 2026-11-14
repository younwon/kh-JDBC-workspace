package com.kh.movie.view;

import java.util.Scanner; 

import com.kh.movie.controller.MovieController;

public class MovieView {
	Scanner scanner = new Scanner(System.in);
	MovieController mc = new MovieController();
	
	public void mainMenu() {
	    while (true) {
	        System.out.println();
	        System.out.println("영화 관리 프로그램입니다");
	        System.out.println("1. 영화 전체 조회");
	        System.out.println("2. 영화 리뷰 조회");
	        System.out.println("0. 프로그램 종료");
	        System.out.print("메뉴를 선택하세요 > ");

	        String input = scanner.nextLine();

	        switch (input) {
	            case "1":
	            	selectAll();
	                break;
	            case "2":
	            	selectMovieAndReviews();
	                break;
	            case "3":
	                break;
	            case "4":
	                break;
	            case "0":
	                System.out.println("프로그램을 종료합니다");
	                scanner.close();
	                return;
	            default:
	                System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
	        }
	    }
	}
	
	private void selectAll() {
		// TODO Auto-generated method stub
		
	}

	private void selectMovieAndReviews() {
		// TODO Auto-generated method stub
		
	}

}
