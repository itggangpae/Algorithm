package algorithm;

import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 라인 수:");
		int line = sc.nextInt();
		
		int su = 1;
		for(int i=0; i<line; i=i+1) {
			//공백 수 출력
			for(int j=0; j<line-i-1; j=j+1) {
				System.out.print(" ");
			}
			if(i==0) {
				System.out.print(su%10);
				su = su + 1;
			}else if(i == line-1) {
				for(int j=0; j<2*line-1; j=j+1) {
					System.out.print(su%10);
					su = su + 1;
				}
			}else {
				System.out.print(su%10);
				su = su + 1;
				for(int j=0; j<2*i-1; j=j+1) {
					System.out.print(" ");
				}
				System.out.print(su%10);
				su = su + 1;
			}
			System.out.print("\n");
		}
		
		sc.close();
	}

}
