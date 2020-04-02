package linear;

class Node {
	char data;
	Node next;
}

public class LinkedListStack {

	// 출발점을 만들기 위한 노드
	private Node head;

	// 생성자 - head에 노드 할당
	public LinkedListStack() {
		head = new Node();
	}

	// 데이터를 마지막에 추가하는 메소드
	public void push(char data) {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		Node node = new Node();
		node.data = data;
		temp.next = node;
	}

	//데이터 개수를 리턴하는 메소드
	public int size() {
		Node temp = head;
		int cnt = 0;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;
			cnt = cnt + 1;
		}
		return cnt;
	}

	//마지막 데이터를 삭제하고 리턴하는 메소드
	public char pop() {
		if (size() == 0) {
			return 0;
		}
		Node node = head;
		int i = 0;
		while (i < size() - 1) {
			node = node.next;
			i = i + 1;
		}
		Node lastNode = node.next;
		char ch = lastNode.data;
		node.next = null;
		lastNode = null;
		return ch;
	}

	//Stack 전체를 순회하는 메소드
	public void printStack() {
		Node temp = head.next;
		if (temp == null) {
			System.out.println("리스트에 데이터가 없습니다.");
		} else {
			while (true) {
				System.out.print(temp.data);
				temp = temp.next;
				if (temp == null) {
					break;
				}
			}
			System.out.println();
		}
	}

	//Stack을 초기화하는 메소드
	public void clear() {
		if (size() == 0) {
			return;
		}
		while (true) {
			char ch = pop();
			if (ch == 0) {
				break;
			}
		}
	}
}
