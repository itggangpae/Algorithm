package sorting;

public class QuickSort {

	public static void quickSort(int left, int right, int[] data) {
		// 정렬 결과 출력
		for (int temp : data) {
			System.out.print(temp + "\t");
		}
		System.out.println();
		
		// 가장 왼쪽의 데이터를 pivot으로 설정
		int pivot = left;
		// 피봇의 위치를 j에 대입
		int j = pivot;
		// 피봇과 비교할 데이터의 위치의 초기값을 설정
		int i = left + 1;

		if (left < right) {
			for (; i <= right; i=i+1) {
				if (data[i] < data[pivot]) {
					j = j + 1;
					int temp = data[j];
					data[j] = data[i];
					data[i] = temp;
				}
			}

			int temp = data[left];
			data[left] = data[j];
			data[j] = temp;

			pivot = j;

			quickSort(left, pivot - 1, data);
			quickSort(pivot + 1, right, data);
		}

	}

	public static void main(String[] args) {

		int[] list = { 69, 10, 30, 2, 14, 8, 31, 22, 16 };
		int n = list.length;
		// 퀵 정렬 수행(left: 배열의 시작 = 0, right: 배열의 끝 = 8)
		quickSort(0, n - 1, list);

		// 정렬 결과 출력
		System.out.println("정렬 후");
		for (int temp : list) {
			System.out.print(temp + "\t");
		}
		System.out.println();
	}

}
