package linear;

public class ArrayCreate {

	public static void main(String[] args) {
		//배열의 생성
		String [] strAr = {"컴퓨터개론", "운영체제", "프로그래밍언어", "자료구조", "알고리즘"};
		int [] intAr = new int[3];
		intAr[0] = 100;
		intAr[1] = 200;
		intAr[2] = 300;
		
		//배열의 데이터 모든 요소 접근
		
		//인덱스를 이용한 모든 데이터 접근
		int len = strAr.length;
		for(int i=0; i<len; i++) {
			System.out.print(strAr[i] + "\t");
		}
		System.out.println();
		
		//빠른 열거를 이용한 접근
		for(int temp : intAr) {
			System.out.print(temp + "\t");
		}
		System.out.println();
	}
}
