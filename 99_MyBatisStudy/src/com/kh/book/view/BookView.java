package com.kh.book.view;

import java.util.List;
import java.util.Scanner;

import com.kh.book.controller.BookController;
import com.kh.book.model.dto.BookDto;

/** 콘솔에서 사용자 입력을 받고 Controller에 요청하는 View입니다. */
public class BookView {
	private final Scanner sc = new Scanner(System.in);
	private final BookController controller = new BookController();

	public static void main(String[] args) {
		new BookView().mainMenu();
	}

	public void mainMenu() {
		while (true) {
			System.out.println("\n=== 도서 관리 ===");
			System.out.println("1. 도서 등록");
			System.out.println("2. 전체 도서 조회");
			System.out.println("3. 도서 상세 조회");
			System.out.println("4. 도서 수정");
			System.out.println("5. 도서 삭제");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 > ");

			String menu = sc.nextLine();
			try {
				switch (menu) {
				case "1": insertBook(); break;
				case "2": selectAll(); break;
				case "3": selectByNo(); break;
				case "4": updateBook(); break;
				case "5": deleteBook(); break;
				case "0":
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					return;
				default:
					System.out.println("올바른 메뉴를 선택하세요.");
				}
			} catch (UnsupportedOperationException e) {
				System.out.println("Controller 구현이 아직 완료되지 않았습니다: " + e.getMessage());
			}
		}
	}

	private void insertBook() {
		System.out.println("\n[도서 등록]");
		System.out.print("제목 > ");
		String title = sc.nextLine();
		System.out.print("저자 > ");
		String author = sc.nextLine();
		int price = readInt("가격 > ");

		int result = controller.insertBook(title, author, price);
		printResult(result, "등록");
	}

	private void selectAll() {
		System.out.println("\n[전체 도서 조회]");
		List<BookDto> books = controller.selectAll();
		if (books == null || books.isEmpty()) {
			System.out.println("조회된 도서가 없습니다.");
			return;
		}
		for (BookDto book : books) {
			System.out.println(book);
		}
	}

	private void selectByNo() {
		System.out.println("\n[도서 상세 조회]");
		int bookNo = readInt("도서 번호 > ");
		BookDto book = controller.selectByNo(bookNo);
		System.out.println(book == null ? "해당 도서를 찾을 수 없습니다." : book);
	}

	private void updateBook() {
		System.out.println("\n[도서 수정]");
		int bookNo = readInt("수정할 도서 번호 > ");
		System.out.print("새 제목 > ");
		String title = sc.nextLine();
		System.out.print("새 저자 > ");
		String author = sc.nextLine();
		int price = readInt("새 가격 > ");

		int result = controller.updateBook(bookNo, title, author, price);
		printResult(result, "수정");
	}

	private void deleteBook() {
		System.out.println("\n[도서 삭제]");
		int bookNo = readInt("삭제할 도서 번호 > ");
		int result = controller.deleteBook(bookNo);
		printResult(result, "삭제");
	}

	private int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자로 입력하세요.");
			}
		}
	}

	private void printResult(int result, String action) {
		System.out.println(result > 0 ? action + " 성공" : action + " 실패");
	}
}
