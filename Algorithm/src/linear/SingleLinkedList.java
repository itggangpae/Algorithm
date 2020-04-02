package linear;

public class SingleLinkedList {
	class Node {
		int data;
		Node next;
	}
	
	// 출발점을 만들기 위한 노드
	private Node head;

	// 생성자 - head에 노드 할당
	public SingleLinkedList() {
		head = new Node();
	}

	// 데이터를 마지막에 추가하는 메소드
	public void addElement(int data) {
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

	// pos에 해당하는 데이터를 찾아오는 메소드
	public Node getElement(int pos) {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 가져올 수 없습니다.");
			return null;
		}
		if (pos < 0 || pos >= size()) {
			System.out.println("데이터를 가져올 수 없는 위치입니다.");
			return null;
		}
		int i = 0;
		Node node = head.next;
		while (i < pos) {
			i = i + 1;
			node = node.next;
		}
		return node;
	}

	// list 전체를 순회하는 메소드
	public void traversal() {
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
				System.out.print("->");
			}
			System.out.println();
		}
	}

	// list의 데이터 개수를 리턴하는 메소드
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

	// 위치와 데이터를 받아서 데이터를 중간에도 삽입할 수 있는 메소드
	public void insertElement(int pos, int data) {

		if (pos < 0 || pos > size()) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}

		Node node = new Node();
		node.data = data;

		Node temp = getElement(pos - 1);
		node.next = temp.next;
		temp.next = node;
	}

	// pos 위치에 해당하는 데이터를 삭제하는 메소드
	public void removeElement(int pos) {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 삭제할 수 없습니다.");
			return;
		}
		if (pos < 0 || pos >= size()) {
			System.out.println("삭제할 수 없는 위치입니다.");
			return;
		}
		Node node = null;
		if (pos == 0) {
			node = head;
		} else {
			node = getElement(pos - 1);
		}
		Node temp = node.next;
		node.next = temp.next;
		temp = null;
	}

	// pos 위치에 해당하는 데이터를 수정하는 메소드
	public void updateElement(int pos, int data) {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 수정할 수 없습니다.");
			return;
		}
		if (pos < 0 || pos >= size()) {
			System.out.println("수정할 수 없는 위치입니다.");
			return;
		}

		Node node = getElement(pos);
		node.data = data;

	}

	// list 전체를 초기화하는 메소드
	public void clearElement() {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 삭제할 필요가 없습니다.");
			return;
		}
		Node temp = head;
		while (temp.next != null) {
			Node node = temp.next;
			temp.next = temp.next.next;
			node = null;
		}
	}
}
