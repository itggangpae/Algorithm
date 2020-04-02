package algorithm;

public class InsertionSort {

	public static void main(String[] args) {
		int[] list = { 5, 3, 8, 4, 9, 1, 6, 2, 7 };
		for (int i = 1; i < list.length; i=i+1) {
			int standard = list[i];  // 기준
			int j = i-1;
			for( ;j>=0; j=j-1) {
				if(standard >= list[j]) {
					break;
				}
				list[j+1] = list[j];
			}
			list[j + 1] = standard;  // 기준값 저장
		}
		
		for(int e : list) {
			System.out.print(e + "\t");
		}
	}
}
