package linear;

import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		//데이터를 마지막에 추가
		list.add("서울특별시");
		list.add("인천광역시");
		
		//데이터를 중간에 추가
		list.add(1, "부산광역시");
		
		//데이터 개수 확인
		System.out.println(list.size());
		//데이터 확인
		System.out.println(list);
		
		//데이터 제거
		list.remove(2);
		
		//전체 데이터 접근
		for(String imsi : list) {
			System.out.println(imsi);
		}
		
	}

}
