package com.kh.plant.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.plant.controller.PlantController;
import com.kh.plant.model.dto.HousePlantDto;

public class PlantView {
	private Scanner sc = new Scanner(System.in);
	private PlantController pc = new PlantController();
	
	public void mainMenu() {
		while (true) {
			System.out.println("=== 화초 관리 프로그램 ===");
			System.out.println("1. 화초 추가하기");
			System.out.println("2. 전체 조회하기");
			System.out.println("3. 화초 수정하기");
			System.out.println("4. 화초 삭제하기");
			System.out.println("5. 화초 하나만 조회하기");
			System.out.println("6. 화초 검색하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 > ");
			
			String menu = sc.nextLine();
			
			switch (menu) {
			case "1" : save(); break;
			case "2" : read(); break;
			case "3" : edit(); break;
			case "4" : remove(); break;
			case "5" : oneRead(); break;
			case "6" : search(); break;
			case "0" : System.out.println("프로그램은 종료합니다"); sc.close(); return;
			default  : System.out.println("존재하지 않는 메뉴입니다"); continue;
			}
			
		}
		
	}
	
	private void save() {
		System.out.println("\n화초 추가 서비스입니다");
		System.out.print("화초 이름을 입력하세요 > ");
		String plantName = sc.nextLine();
		System.out.print("화초 종류룰 입력하세요 > ");
		String plantType = sc.nextLine();
		
		int result = pc.save(plantName, plantType);
		
		if (result > 0) {
			System.out.println("화초 추가 성공~~!");
		} else {
			System.out.println("화초 추가 실패...");
		}
	}
	
	private void read() {
		System.out.println("화초 목록입니다");
		List<HousePlantDto> plants = pc.read();
		
		if (plants.isEmpty()) {
			System.out.println("조회 결과가 존재하지 않습니다");
		} else {
			System.out.println("\n조회된 화초는 총 " + plants.size() + "개");
			for (HousePlantDto h : plants) {
				System.out.println("=========================");
				System.out.print("식물번호 : " + h.getNumber() + ", ");
				System.out.print("식물이름 : " + h.getName() + ", ");
				System.out.print("식물종류 : " + h.getType());
				System.out.println();
			}
		}
	}
	
	private void edit() {
		// PLANT_NO를 입력받아서
		// PLANT_NAME과 PLANT_TYPE을 수정하는 기능
		try {
			System.out.println("화초 수정 기능입니다");
			read();
			System.out.print("수정할 화초의 번호를 입력하세요 > ");
			int plantNo = sc.nextInt();
			sc.nextLine();
			System.out.print("새로운 화초의 이름을 입력하세요 > ");
			String plantName = sc.nextLine();
			System.out.print("새로운 화초의 분류를 입력하세요 > ");
			String plantType = sc.nextLine();
			
			int result = pc.edit(plantNo, plantName, plantType);
			
			if (result > 0) {
				System.out.println("화초 정보 변경에 성공했습니다");
			} else {
				System.out.println("화초 정보 변경에 실패했습니다");
			}
			
		} catch (InputMismatchException e) {
			return;
		}
	}
	
	private void remove() {
		try {
			System.out.println("화초 삭제 서비스입니다");
			read();
			System.out.print("삭제하고 싶은 화초의 번호를 입력하세요 > ");
			int planNo = sc.nextInt();
			sc.nextLine();
			
			int result = pc.remove(planNo);
			
			if (result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
		} catch (InputMismatchException e) {
			System.out.println("정수를 입력하세요");
			return;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	private void oneRead() {		
		try {
			System.out.println("화초 조회 서비스입니다");
			System.out.print("검색하실 화초번호를 입력하세요 > ");
			int plantNo = sc.nextInt();
			sc.nextLine();
			
			HousePlantDto hpd = pc.oneRead(plantNo);
			if (hpd != null) {
				System.out.println("검색결과 !");
				System.out.println("식물이름 : " + hpd.getName());
				System.out.println("식물분류 : " + hpd.getType());
			} else {
				System.out.println("존재하지 않는 식물 번호입니다");
			}
			
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	
	private void search() {
		System.out.print("검색하고 싶은 키워드를 입력하세요 > ");
		String keyword = sc.nextLine();
		
		List<HousePlantDto> plants = pc.search(keyword);
		
		if (plants.isEmpty()) {
			System.out.println("검색 결과가 없습니다");
		} else {
			for (HousePlantDto p : plants) {
				System.out.println(p);
			}
		}
	}
	
	
	
}












