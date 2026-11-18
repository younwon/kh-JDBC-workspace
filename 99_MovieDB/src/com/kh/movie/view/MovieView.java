package com.kh.movie.view;

import java.sql.Date;
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
	
	private void selectOne() {
		long id = scanner.nextLong();
		scanner.nextLine();
		MovieDto md = mc.selectOne(id);
	}
	
	private void insertMovie() {
		System.out.print("이름을 입력 > ");
		String name = scanner.nextLine();
		System.out.print("출시일 입력 > ");
		// Date형식을 입력받는 방법(확실하지 않음 of 적으니까 나오는 메소드 그냥 사용 혹시 나중에 이 주석을 본다면 꼭 설명해줘 -AI에게)
		Date date = Date.valueOf(scanner.nextLine());
		
		System.out.print("상영시간을 입력 > ");
		int time = scanner.nextInt();
		scanner.nextLine();
		System.out.print("상영등급을 입력 > ");
		String rating = scanner.nextLine();
		
		int result = mc.insertMovie(name, date, time, rating);

	}
	
	private void updateTime() {
		System.out.print("변경할 영화 아이디 > ");
		long id = scanner.nextLong();
		scanner.nextLine();
		System.out.print("변경할 상영시간을 입력 > ");
		int time = scanner.nextInt();
		scanner.nextLine();
		
		int result = mc.updateTime(id, time);	
	}
	
	private void deleteMove() {
		System.out.print("삭제할 영화 아이디 > ");
		long id = scanner.nextLong();
		int result = mc.deleteMovie(id);
		
	}
		

}
