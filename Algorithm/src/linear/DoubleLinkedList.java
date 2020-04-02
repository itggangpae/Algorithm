package linear;

public class DoubleLinkedList {
	class Node {
		int data;
		Node next;
		Node prev;
	}
	
	// 출발점을 만들기 위한 노드
	private Node head;
	// 종료점을 만들기 위한 노드
	private Node tail;

	// 생성자 - head에 노드 할당
	public DoubleLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}

	// list의 데이터 개수를 리턴하는 메소드
	public int size() {
		Node temp = head;
		int cnt = 0;
		while (true) {
			temp = temp.next;
			if (temp == tail) {
				break;
			}
			cnt = cnt + 1;
		}
		return cnt;
	}

	// 데이터를 마지막에 추가하는 메소드
	public void addElement(int data) {
		Node temp = head;
		Node node = new Node();
		node.data = data;

		// 데이터가 없는 경우
		if (temp.next == tail) {
			head.next = node;
			node.prev = head;
		} else {
			Node last = tail.prev;
			last.next = node;
			node.prev = last;

		}
		tail.prev = node;
		node.next = tail;
	}

	// pos에 해당하는 데이터를 찾아오는 메소드
	public Node getElement(int pos) {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 가져올 수 없습니다.");
			return null;
		}
		Node temp = null;
		if (pos >= 0) {
			if (pos >= size()) {
				System.out.println("데이터를 가져올 수 없는 위치입니다.");
				return null;
			}
			int i = 0;
			temp = head;
			while (i <= pos) {
				temp = temp.next;
				i = i + 1;
			}
		} else {
			pos = pos * -1;
			if (pos > size()) {
				System.out.println("데이터를 가져올 수 없는 위치입니다.");
				return null;
			}
			int i = 1;
			temp = tail;
			while (i <= pos) {
				temp = temp.prev;
				i = i + 1;
			}
		}
		return temp;
	}

	// 이전 데이터를 찾아오는 메소드
	public Node prevElement(Node node) {
		Node temp = null;
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 가져올 수 없습니다.");
		} else if (node.prev == head) {
			System.out.println("첫번째 노드라서 다음 데이터가 없습니다.");
		} else {
			temp = node.prev;
		}
		return temp;
	}

	// 다음 데이터를 찾아오는 메소드
	public Node nextElement(Node node) {
		Node temp = null;
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 가져올 수 없습니다.");
		} else if (node.next == tail) {
			System.out.println("마지막 노드라서 다음 데이터가 없습니다.");
		} else {
			temp = node.next;
		}
		return temp;
	}

	// list 전체를 순회하는 메소드
	public void traversal() {
		Node temp = head;
		if (head.next == tail) {
			System.out.println("리스트에 데이터가 없습니다.");
		} else {
			while (true) {
				temp = temp.next;
				System.out.print(temp.data);
				if (temp.next == tail) {
					break;
				}
				System.out.print("->");
			}
			System.out.println();
		}
	}

	// list 전체를 순회하는 메소드
	public void reversetraversal() {
		Node temp = tail;
		if (head.next == tail) {
			System.out.println("리스트에 데이터가 없습니다.");
		} else {
			while (true) {
				temp = temp.prev;
				System.out.print(temp.data);
				if (temp.prev == head) {
					break;
				}
				System.out.print("->");
			}
			System.out.println();
		}
	}

	// 위치와 데이터를 받아서 데이터를 중간에도 삽입할 수 있는 메소드
	public void insertElement(int pos, int data) {
		if(pos >= 0) {
			if(pos > size()) {
				System.out.println("삽입할 수 없는 위치 입니다.");
			}
			else if(pos == size()) {
				addElement(data);
			}else {
				Node node = new Node();
				node.data = data;
				int i=0;
				Node temp = head;
				while(i <= pos-1) {
					temp = temp.next;
					i = i + 1;
				}
				node.next = temp.next;
				temp.next.prev = node;
				
				temp.next = node;
				node.prev = temp;
			}
		}else {
			pos = pos * -1;
			if(pos > size()+1) {
				System.out.println("삽입할 수 없는 위치 입니다.");
			}else if(pos == -1) {
				addElement(data);
			}else {
				Node node = new Node();
				node.data = data;
				int i=0;
				Node temp = tail;
				while(i < pos) {
					temp = temp.prev;
					i = i + 1;
				}
				node.next = temp.next;
				temp.next.prev = node;
				
				temp.next = node;
				node.prev = temp;
			}
		}
		
	}

	// pos 위치에 해당하는 데이터를 수정하는 메소드
	public void updateElement(int pos, int data) {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 수정할 수 없습니다.");
			return;
		}
		if (pos >= size() || pos < -size()) {
			System.out.println("수정할 수 없는 위치입니다.");
			return;
		}

		Node node = getElement(pos);
		node.data = data;
	}

	// pos 위치에 해당하는 데이터를 삭제하는 메소드
	public void removeElement(int pos) {
		if (size() == 0) {
			System.out.println("데이터가 없어서 데이터를 삭제할 수 없습니다.");
			return;
		}
		if (pos >= size() || pos < -size()) {
			System.out.println("삭제할 수 없는 위치입니다.");
			return;
		}

		if(pos >= 0) {
			Node temp = head;
			int i=0;
			while(i<pos) {
				temp = temp.next;
				i=i+1;
			}
			Node node = temp.next;
			temp.next = node.next;
			node.next.prev = temp;
			node = null;
		}else {
			pos = -pos;
			Node temp = tail;
			int i=0;
			while(i < pos) {
				temp = temp.prev;
				i=i+1;
			}
			Node prev = temp.prev;
			Node next = temp.next;
			prev.next = next;
			next.prev = prev;
			temp = null;
		
		}

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
