package com.kh.movie.view;

import java.util.List;
import java.util.Scanner;

import com.kh.movie.controller.MovieController;
import com.kh.movie.model.dto.MovieDto;

public class MovieView {
	Scanner scanner = new Scanner(System.in);
	MovieController mc = new MovieController();
	
	public void mainMenu() {
	    while (true) {
	        System.out.println();
	        System.out.println("영화 관리 프로그램입니다");
	        System.out.println("1. 영화 전체 조회");
	        System.out.println("2. 영화 추가");
	        System.out.println("3. 영화 삭제");
	        System.out.println("4. 영화 검색");
	        System.out.println("0. 프로그램 종료");
	        System.out.print("메뉴를 선택하세요 > ");

	        String input = scanner.nextLine();

	        switch (input) {
	            case "1":
	            	selectAll();
	                break;
	            case "2":
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
		List<MovieDto> list = mc.selectAll();
		if (list.isEmpty()) {
			System.out.println("조회결과없음");
		} else {
			for (MovieDto movieDto : list) {
				System.out.println(movieDto);
			}
		}
		
	}

}
