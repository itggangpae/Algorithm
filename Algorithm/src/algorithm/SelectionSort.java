package algorithm;

public class SelectionSort {

	public static void main(String[] args) {
		int [] ar = {20, 30, 10, 50, 40};
		for(int i=0; i<ar.length; i=i+1) {
			for(int j=i+1; j<ar.length; j=j+1) {
				if(ar[i] > ar[j]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		
		for(int item : ar) {
			System.out.print(item + "\t");
		}

	}

}
