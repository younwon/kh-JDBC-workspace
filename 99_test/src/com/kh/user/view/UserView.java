package com.kh.user.view;

import java.util.Scanner;

import com.kh.user.controller.UserController;

public class UserView {
	private Scanner sc = new Scanner(System.in);
	private UserController uc = new UserController();
	
	public void mainMenu() {
		while (true) {
			System.out.println("=== 사용자 관리 프로그램 ===");
			System.out.println("1. 사용자 추가하기");
			System.out.println("");
			System.out.println("");
			System.out.print("메뉴를 선택하세요 > ");
			
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1" : save(); break;
			case "0" : System.out.println("프로그램은 종료합니다"); sc.close(); return;
			default  : System.out.println("존재하지 않는 메뉴입니다"); continue;
			}
			
		}
		
	}
	
	private void save() {
		System.out.print("이름 > ");
		String name = sc.nextLine();
		System.out.print("성별 > ");
		String gender = sc.nextLine();
		int result = uc.save(name, gender);
		
		if (result > 0) {
			System.out.println("추가성공");
		} else {
			System.out.println("추가실패");
		}
	}

}
