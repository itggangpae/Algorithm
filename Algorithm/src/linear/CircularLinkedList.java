package linear;

public class CircularLinkedList {
	
	class Node {
		int data;
		Node next;
	}
	
	// 출발점을 만들기 위한 노드
	private Node head;

	// 생성자 - head에 노드 할당
	public CircularLinkedList() {
		head = new Node();
	}

	// list의 데이터 개수를 리턴하는 메소드
	public int size() {
		Node temp = head;
		int cnt = 0;
		if (temp.next == null) {
			return cnt;
		}
		while (true) {
			temp = temp.next;
			cnt = cnt + 1;
			if (temp.next == head.next) {
				break;
			}
		}
		return cnt;
	}

	// 데이터를 마지막에 추가하는 메소드
	public void addElement(int data) {
		Node temp = head;
		Node node = new Node();
		node.data = data;

		// 데이터가 없는 경우
		if (temp.next == null) {
			head.next = node;
			node.next = node;
		}
		// 데이터가 존재하는 경우에는 데이터의 마지막까지 이동시킨 후 마지막 노드 다음이 새로운 노드가 되고
		// 새로운 노드 의 다음은 첫번째 노드
		else {
			do {
				temp = temp.next;
			} while (temp.next != head.next);
			temp.next = node;
			node.next = head.next;
		}
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
				if (temp == head.next) {
					break;
				}
				System.out.print("->");
			}
			System.out.println();
		}
	}

	// 위치와 데이터를 받아서 데이터를 중간에도 삽입할 수 있는 메소드
	public void insertElement(int pos, int data) {

		if (pos < 0 || pos > size()) {
			System.out.println("삽입할 수 없는 위치입니다.");
			return;
		}
		// 마지막에 삽입하고자 하는 경우에는 addElement() 호출
		else if (pos == size()) {
			addElement(data);
			return;
		}
		Node temp = head;

		Node node = new Node();
		node.data = data;
		int i = 0;
		// 첫번째에 노드를 추가하고자 하는 경우 마지막 노드가 추가하는 노드를 가리키는 작업을 수행하고 head의 다음에 추가
		if (pos == 0) {
			temp = getElement(size() - 1);
			temp.next = node;

			node.next = head.next;
			head.next = node;
			return;
		}
		// 첫번째가 아닌 경우 추가
		i = 0;
		while (i < pos) {
			temp = temp.next;
			i = i + 1;
		}
		node.next = temp.next;
		temp.next = node;
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

	//pos 위치에 해당하는 데이터를 삭제하는 메소드
	public void removeElement(int pos) {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 삭제할 수 없습니다.");
			return;
		}
		if (pos < 0 || pos >= size()) {
			System.out.println("삭제할 수 없는 위치입니다.");
			return;
		}
		
		if(size() == 1 && pos == 0) {
			Node temp = head.next;
			temp = null;
			head.next = null;
		}
		else if(pos == 0) {
			Node last = getElement(size()-1);
			Node node = head.next;
			last.next = node.next;
			head.next = node.next;
			node = null;
		}else if(pos == size()-1) {
			Node temp = getElement(size()-2);
			temp.next = null;
			temp.next = head.next;
		}else {
			Node temp = getElement(pos-1);
			Node node = temp.next;
			temp.next = node.next;
			node = null;
		}
		
	}
	
	//현재 노드의 이전 위치에 해당하는 데이터를 리턴하는 메소드
	public Node prevElement(Node node) {
			if (size() == 0) {
				System.out.println("데이터가 없어서 데이터를 가져올 수 없습니다.");
				return null;
			}
			if (size() == 1) {
				System.out.println("데이터가 1개라서 이전 노드가 자기 자신입니다.");
				return node;
			}
			
			Node temp = node;
			int i=0;
			while(i < size()-1) {
				i = i + 1;
				temp = temp.next;
			}
			return temp;
			
	}

	// list 전체를 초기화하는 메소드
	public void clearElement() {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 삭제할 필요가 없습니다.");
			return;
		}
		while (size() != 0) {
			removeElement(0);
		}
	}
}
