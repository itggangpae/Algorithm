package linear;

public class ArrayMain {

	public static void main(String[] args) {
		Object[] intAr = { 100, 200, 400 };
		System.out.print("기존 배열의 데이터:\t");
		for (Object temp : intAr) {
			System.out.print(temp + "\t");
		}
		System.out.println();

		// 200 다음의 위치에 300을 추가
		Array.insert(intAr, 2, 300);
		System.out.print("300을 중간에 추가:\t");
		for (Object temp : intAr) {
			System.out.print(temp + "\t");
		}
		System.out.println();

		// 마지막 위치에 500을 추가
		Array.append(intAr, 500);
		System.out.print("500을 마지막에 추가:");
		for (Object temp : intAr) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		
		// 200을 제거 
		Array.delete(intAr, 1);
		System.out.print("200을 제거:\t");
		for (Object temp : intAr) {
			System.out.print(temp + "\t");
		}
		System.out.println();
	}
}
