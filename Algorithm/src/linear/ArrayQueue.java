package linear;
//배열로 구현한 문자 큐
public class ArrayQueue{
	private int max;			// 큐의 용량
	private int front;			// 첫 번째 요소 커서
	private int rear;			// 마지막 요소 커서
	private int num;			// 현재 데이터 수
	private char[] que;			// 큐 본체

	// 생성자
	public ArrayQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		que = new char[max];				// 큐 본체용 배열을  생성
	}

	// 큐에 데이터를 인큐
	public void enQueue(char ch) {
		if (num >= max) {
			System.out.println("큐가 가득 참");
		}
		que[rear++] = ch;
		num++;
		if (rear == max) {
			rear = 0;
		}
		System.out.println("삽입한 데이터:" + ch);
	}

	// 큐에서 데이터를 디큐
	public int deQuque(){
		if (num <= 0) {
			System.out.println("큐가 비어 있음");	
			return 0;
		}
		char ch = que[front++];
		System.out.println("삭제된 데이터:" + ch);
		num--;
		if (front == max) {
			front = 0;
		}
		return ch;
	}

	// 큐에서 데이터를 피크 (프런트 데이터를 들여다봄)
	public int peek() {
		if (num <= 0) {
			System.out.println("큐가 비어 있음");	
			return 0;
		}
		return que[front];
	}

	// 큐를 비움
	public void clear() {
		num = front = rear = 0;
	}

	// 큐의 용량을 반환
	public int capacity() {
		return max;
	}

	// 큐에 쌓여 있는 데이터 수를 반환
	public int size() {
		return num;
	}

	// 큐가 비어 있나요?
	public boolean isEmpty() {
		return num <= 0;
	}

	// 큐가 가득 찼나요?
	public boolean isFull() {
		return num >= max;
	}

	// 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력
	public void printQueue() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[(i + front) % max] + " ");
			}
			System.out.println();
		}
	}
}