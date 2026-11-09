package com.kh.snackfood.view;

import java.nio.channels.Pipe.SourceChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kh.snackfood.controller.FoodController;
import com.kh.snackfood.model.dto.FoodReviewDto;
import com.kh.snackfood.model.dto.SnackFoodDto;

public class FoodView {
	private FoodController fc = new FoodController();
	private Scanner sc = new Scanner(System.in);
	
	/*
	 * 한국에서 메소드 식별자 짖는 방법(Method naming convention)
	 * Food : 기준
	 * case 1.
	 * C : insertFood(Food food)
	 * R : selectFood(Long id) 단수, selectFoodList() 복수
	 * U : updateFood(Food food)
	 * D : deleteFood(Long id)
	 * 
	 * case 2.
	 * C : saveFood(Food food)
	 * R : findFoodById(Long id) 단수, findAllFoods() 복수
	 * U : updateFood(Food food)
	 * D : deleteFoodById(Long id)
	 */
	
	public void mainMenu() {
		while (true) {
			System.out.println("분식 리뷰 시스템에 오신것을 환영합니다");
			System.out.println("1. 모든 분식 및 리뷰 조회하기");
			System.out.println("2. 분식 검색하기");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 선택 > ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1" : selectFoodList(); break;
			case "2" : selectByCondition(); break;
			case "9" : System.out.println("프로그램 종료"); sc.close(); return;
			default: System.out.println("메뉴에 없는 선택입니다");
			}
		}
	}
	
	private void selectFoodList() {
		List<SnackFoodDto> foods = fc.selectFoodList();
		
		if (foods.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다");
		}else {
			for (SnackFoodDto s : foods) {
				System.out.println("===========================");
				System.out.println(s.getFoodName() + "의 리뷰목록");
				System.out.println("===========================");
				List<FoodReviewDto> reviews = s.getReviews();
				if (reviews.isEmpty()) {
					System.out.println(s.getFoodName() + "은(는) 리뷰가 존재하지 않습니다");
				}else {
					for (FoodReviewDto r : reviews) {
						System.out.println("리뷰 내용 : " + r.getReviewContent() + " / 별점 " + r.getRating());
					}
				}
			}
		}
		
	}
	
	private void selectByCondition() {
		System.out.println("검색 조건을 설정해주세요");
		System.out.print("1. 분식메뉴 / 2. 리뷰작성자 / 3. 리뷰 내용 > ");
		String menuNo = sc.nextLine();
		System.out.print("검색하실 키워드를 입력하세요 > ");
		String keyword = sc.nextLine();
		
		/*
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("menuNo", menuNo);
		arguments.put("keyword", keyword);
		*/
		
		Map<String, String> arguments = Map.of("menuNo", menuNo, "keyword", keyword);
		
		List<SnackFoodDto> foods = fc.selectByCondition(arguments);
		
		if (foods.isEmpty()) {
			System.out.println("검색 결과가 존재하지 않습니다");
		}else {
			for (SnackFoodDto s : foods) {
				System.out.println(s);
			}
		}
	}
	
	
	
}
