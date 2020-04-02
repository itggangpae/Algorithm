package nonlinear;

class AdjMatrix{
	//배열의 간선을 저장할 배열
	private int matrix[][];
	//그래프의 방향성을 저장할 변수
	private boolean isDirect;
	//그래프의 크기를 저장할 변수
	private int size;
	
	
	//생성자 - 그래프의 크기와 방향성을 매개변수로 받아서 생성
	public AdjMatrix(int size, boolean isDirect) {
		matrix = new int[size][size];
		this.isDirect = isDirect;
		this.size = size;
	}
	
	//간선을 추가하는 메소드
	public void insertEdge(int v1, int v2){
		if(v1>=size || v2>=size) {
			System.out.println("그래프에 없는 정점입니다!!");
		}
		else {
			if(isDirect == true) {
				matrix[v1][v2] = 1;
			}else {
				matrix[v1][v2] = 1;
				matrix[v2][v1] = 1;
			}
		}
	}
	
	//간선을 제거하는 메소드
	public void removeEdge(int v1, int v2){
		if(v1>=size || v2>=size) {
			System.out.println("그래프에 없는 정점입니다!!");
		}
		else {
			if(isDirect == true) {
				matrix[v1][v2] = 0;
			}else {
				matrix[v1][v2] = 0;
				matrix[v2][v1] = 0;
			}
		}
	}
	
	//배열의 내용을 출력하는 메소드
	public void printAdjMarix() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}