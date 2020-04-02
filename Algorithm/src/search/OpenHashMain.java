package search;

import java.util.Scanner;

public class OpenHashMain {
	static Scanner stdIn = new Scanner(System.in);

	// 데이터 (회원번호 + 이름)
	static class Data {
		static final int NO   = 1;		// 번호를 읽어 들일까요?
		static final int NAME = 2;		// 이름을 읽어 들일까요?

		private Integer no;				// 회원번호 (키 값)
		private String  name;			// 이름

		// 키 값
		Integer keyCode() {
			return no;
		}

		// 문자열을 반환합니다.
		public String toString() {
			return name;
		}

		// 데이터를 입력합니다.
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호：");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름：");
				name = stdIn.next();
			}
		}
	}

	// 메뉴 열거형
	enum Menu {
		ADD(      "추가"),
		REMOVE(   "삭제"),
		SEARCH(   "검색"),
		DUMP(     "출력"),
		TERMINATE("종료");

		private final String message;			// 나타낼 문자열 

		static Menu MenuAt(int idx) {			// 서수가 idx인 열거를 반환합니다.
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {					// 생성자
			message = string;
		}

		String getMessage() {					// 나타낼 문자열을 반환
			return message;
		}
	}

	// 메뉴 선택
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print("：");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;								// 메뉴
		Data data;								// 추가용 데이터 참조
		Data temp = new Data();					// 입력용 데이터

		OpenHash<Integer, Data> hash = new OpenHash<Integer, Data>(13);

		do {
			switch (menu = SelectMenu()) {
			 case ADD :									// 추가
				data = new Data();
				data.scanData("추가", Data.NO | Data.NAME);
			 	int k = hash.add(data.keyCode(), data);
			 	switch (k) {
			 	 case 1: System.out.println("그 키 값은 이미 등록되어 있습니다.");
			 	 			break;
			 	 case 2: System.out.println("해시 테이블이 가득 찼습니다.");
			 	 			break; 
			 	}
			 	break;

			 case REMOVE :								// 삭제
			 	temp.scanData("삭제", Data.NO);
			 	hash.remove(temp.keyCode());
			 	break;

			 case SEARCH :								// 검색
				temp.scanData("검색", Data.NO);
			 	Data t = hash.search(temp.keyCode());
			 	if (t != null)
			 		System.out.println("그 키를 갖는 데이터는 " + t + "입니다.");
				else
		 			System.out.println("그 데이터가 없습니다.");
			 	break;

			 case DUMP : 								// 출력
			 	hash.printHash();
			 	break;
			}
		} while (menu != Menu.TERMINATE);
	}
}
