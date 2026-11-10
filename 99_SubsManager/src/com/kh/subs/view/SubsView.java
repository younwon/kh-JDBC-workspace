package com.kh.subs.view;

import java.util.List;
import java.util.Scanner;

import com.kh.subs.controller.SubsController;
import com.kh.subs.model.dto.SubscriptionDto;

public class SubsView {
	private Scanner scanner = new Scanner(System.in);
	private SubsController sc = new SubsController();
	
	public void mainMenu() {
		while (true) {
			System.out.println();
			System.out.println("구독 서비스 관리 프로그램입니다");
			System.out.println("1. 구독 전체 조회히가");
			System.out.println("2. 구독 추가하기");
			System.out.println("3. 구독 하나만 조회하기");
			System.out.println("4. 월 요금 변경하기");
			System.out.println("5. 구독 해지하기");
			System.out.println("6. 카테고리로 검색하기");
			System.out.println("7. 선택해서 검색하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.println();
			System.out.print("사용하실 메뉴번호를 입력해주세요 > ");
			
			String menu = scanner.nextLine();
			
			switch (menu) {
			case "1" : selectAll(); break;
			case "2" : insertSub(); break;
			case "3" : selectOne(); break;
			case "4" : updateFee(); break;
			case "5" : deleteSub(); break;
			case "6" : searchByCategory(); break;
			case "7" : searchByCondition(); break;
			case "0" : System.out.println("프로그램을 종료합니다"); scanner.close(); return;
			default: System.out.println("없는 메뉴를 선택했습니다");
			}
		}
	}
	
	private void selectAll() {
		List<SubscriptionDto> subs = sc.selectAll();
		
		if (subs.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다");
		}else {
			System.out.println("\n조회된 구독은 총 " + subs.size() + "개!");
			for (SubscriptionDto s : subs) {
				System.out.println("구독번호 : " + s.getSubNo());
				System.out.println("서비스명 : " + s.getSubName());
				System.out.println("월 요금 : " + s.getMonthlyFee() + "원");
				System.out.println("결제일 : " + s.getPaymentDay() + "일");
				System.out.println("카테고리 : " + s.getCategory());
			}
		}
	}
	
	private void insertSub() {
		System.out.println("\n구독 추가 서비스입니다");
		System.out.print("서비스명을 입력하세요 > ");
		String subName = scanner.nextLine();
		System.out.print("월 요금을 입력하세요(원) > ");
		int monthlyFee = scanner.nextInt();
		scanner.nextLine();
		System.out.print("결제일을 입력하세요(1~31) > ");
		int paymentDay = scanner.nextInt();
		scanner.nextLine();
		System.out.print("카테고리를 입력하세요(OTT/음악/쇼핑/기타) > ");
		String category = scanner.nextLine();
		
		try {
			int result = sc.insertSub(subName, monthlyFee, paymentDay, category);
			
			if (result > 0) {
				System.out.println("구독 추가에 성공했습니다~");
			} else {
				System.out.println("구독 추가에 실패했습니다~");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void selectOne() {
		System.out.println("\n구독 조회 서비스입니다");
		System.out.print("조회할 구독번호를 입력하세요 > ");
		int subNo = scanner.nextInt();
		scanner.nextLine();
		
		try {
			SubscriptionDto dto = sc.selectOne(subNo);
			
			if (dto != null) {
				System.out.println("검색결과 !");
				System.out.println("서비스명 : " + dto.getSubName());
				System.out.println("월 요금 : " + dto.getMonthlyFee() + "원");
				System.out.println("결제일 : 매월 " + dto.getPaymentDay() + "일");
				System.out.println("카테고리 : " + dto.getCategory());
			} else {
				System.out.println("존재하지 않는 구독번호입니다");
			}
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void updateFee() {
		System.out.println("\n월 요금 변경 서비스입니다.");
		System.out.print("변경할 구독번호를 입력하세요 > ");
		long subNo = scanner.nextLong();
		scanner.nextLine();
		System.out.print("새 월 요금을 입력하세요(원) > ");
		int monthlyFee = scanner.nextInt();
		scanner.nextLine();
		
		try {
			int result = sc.updateFee(subNo, monthlyFee);
			
			if(result > 0) {
				System.out.println("요금 변경에 성공했습니다!");
			} else {
				System.out.println("요금 변경에 실패했습니다. 구독번호를 확인하세요.");
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	private void deleteSub() {
		System.out.println("\n구독 해지 서비스입니다.");
		System.out.print("해지할 구독번호를 입력하세요 > ");
		int subNo = scanner.nextInt();
		scanner.nextLine();
		
		try {
			int result = sc.deleteSub(subNo);
			
			if (result > 0) {
				System.out.println("구독 해지에 성공했습니다!");
			} else {
				System.out.println("구독 해지에 실패했습니다. 구독번호를 확인하세요.");
			}
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void searchByCategory() {
		System.out.print("\n검색할 카테고리를 입력하세요 > ");
		String keyword = scanner.nextLine();
		
		try {
			List<SubscriptionDto> list = sc.searchByCategory(keyword);
			
			if (list.isEmpty()) {
				System.out.println("검색결과가 존재하지 않습니다");
			} else {
				for (SubscriptionDto s : list) {
					System.out.println(s);
				}
			}
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}
	
	private void searchByCondition() {
		System.out.print("\n검색할 메뉴를 선택하세요(서비스명 1, 카테고리 2) > ");
		String menuNO = scanner.nextLine();
		System.out.print("검색할 키워드를 입력하세요 > ");
		String keyword = scanner.nextLine();
		
		List<SubscriptionDto> list = sc.searchByCondition(menuNO, keyword);
		
		if (list.isEmpty()) {
			System.out.println("검색결과가 존재하지 않습니다");
		} else {
			for (SubscriptionDto s : list) {
				System.out.println(s);
			}
		}
	}

}
