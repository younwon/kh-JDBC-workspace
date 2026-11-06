package com.kh.snackfood.view;

import java.nio.channels.Pipe.SourceChannel;
import java.util.List;
import java.util.Scanner;

import com.kh.snackfood.controller.FoodController;

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
			System.out.print("메뉴 선택 > ");
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1" : selectFoodList(); break;
			case "9" : System.out.println("프로그램 종료"); sc.close(); return;
			default: System.out.println("메뉴에 없는 선택입니다");
			}
		}
	}
	
	private void selectFoodList() {
		
		
		
		fc.selectFoodList();
	}
}
