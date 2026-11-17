package com.kh.movie.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.movie.controller.MovieController;
import com.kh.movie.model.dto.MovieDto;
import com.kh.movie.model.dto.MovieReviewDto;

public class MovieView {
	Scanner scanner = new Scanner(System.in);
	MovieController mc = new MovieController();
	
	public void mainMenu() {
	    while (true) {
	        System.out.println();
	        System.out.println("영화 관리 프로그램입니다");
	        System.out.println("1. 영화 전체 조회");
	        System.out.println("2. 영화 리뷰 조회");
	        System.out.println("3. 옵션별 검색");
	        System.out.println("4. 영화 하나만 조회하기");
	        System.out.println("5. 영화 추가하기");
	        System.out.println("6. 러닝타임 변경하기");
	        System.out.println("7. 영화 삭제하기");
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
	            	searchByCondition();
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
	
	private void selectMovieAndReviews() {
		List<MovieDto> list = mc.selectMovieAndReviews();
		System.out.println(list.size());
		if (list.isEmpty()) {
			System.out.println("조회결과없음");
		} else {
			for (MovieDto s : list) {
				System.out.println("===========================");
				System.out.println(s.getMovieName() + "의 리뷰목록");
				System.out.println("===========================");
				List<MovieReviewDto> reviews = s.getReviews();
				if (reviews.isEmpty()) {
					System.out.println(s.getMovieName() + "은(는) 리뷰가 존재하지 않습니다");
				}else {
					for (MovieReviewDto r : reviews) {
						System.out.println("리뷰 내용 : " + r.getContent() + " / 별점 " + r.getRating());
					}
				}
				System.out.println();
			}
		}
	}
	
	private void searchByCondition() {
		System.out.println("검색 조건을 설정해주세요");
		System.out.print("1. 영화이름 / 2. 영화관람등급 / 3. 리뷰 내용 > ");
		String menuNo = scanner.nextLine();
		System.out.print("검색하실 키워드를 입력하세요 > ");
		String keyword = scanner.nextLine();
		
		
		List<MovieDto> list = mc.searchByCondition(menuNo, keyword);
		
		if (list.isEmpty()) {
			System.out.println("검색 결과가 존재하지 않습니다");
		}else {
			for (MovieDto s : list) {
				System.out.println(s);
			}
		}
	}
		

}
