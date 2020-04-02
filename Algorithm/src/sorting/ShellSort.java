package sorting;

public class ShellSort {
	public static void intervalSort(int a[], int begin, int end, int interval){
		int i, j, item;	
		for(i=begin+interval; i<=end; i=i+interval){
			item = a[i];			
			for(j=i-interval; j>=begin && item<a[j]; j-=interval)
				a[j+interval] = a[j];
			a[j+interval] = item;	
		}		
	}
	
	public static void shellSort(int a[], int size){
		int i, j, interval, t=0;
		interval = size/2;
		while(interval >= 1){
			for(i=0; i<interval; i++)
				intervalSort(a, i, size-1, interval);
			System.out.printf("\nShell Sort %d 단계 : 간 = %d >> ", ++t, interval);
			for(j=0; j<size; j++)
				System.out.printf("%d   ", a[j]);
			System.out.println();
			interval /= 2;
		}
	}
	
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = a.length;
		System.out.printf("\n정렬할 원소 : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		shellSort(a, size);
	}
	
}
