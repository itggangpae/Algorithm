package algorithm;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		int[] list = {1,2,3,4,5,6,7,8,9};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고자 하는 데이터:");
		int iKey = sc.nextInt();
		
		int mid;
		int left = 0;
		int right = list.length - 1;

		while (true) {
			mid = (right + left) / 2;

			if (iKey == list[mid]) {
				System.out.println(iKey + " is in the array with index value: " + mid);
				break;
			}

			if (iKey < list[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			
			if(right < left) {
				System.out.println(iKey + " is not in the array");
				break;
			}
		}
		
		sc.close();

	}

}
